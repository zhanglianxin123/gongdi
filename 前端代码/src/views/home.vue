<template>
<!--  首页-->
  <div class="homeContainer">
    <el-dialog
      title="报警信息"
      :visible.sync="alarmDialog"
      center
      width="30%">
      <span>{{warningInfo.warning_why}}</span>
    </el-dialog>
<!--    首页主体-->
    <div class="bodyContainer">
      <div class="leftContainer">
        <!--      环境数据-->
        <div class="surroundingChart boxBorder">
          <surroundings-data ref="surroundingsData"></surroundings-data>
          <div class="footerBorder"></div>
        </div>
        <!--      报警显示alarm-->
        <div class="alarmShow boxBorder">
          <alarm-show ref="alarmShow"></alarm-show>
          <div class="footerBorder"></div>
        </div>
      </div>
      <div class="rightContainer">
        <!--      地图-->
        <div class="siteMap boxBorder">
          <site-map ref="siteMap"></site-map>
          <div class="footerBorder"></div>
        </div>
        <!--      粉尘浓度与噪音分贝实时显示图表-->
        <div class="Chart boxBorder">
            <pm-charts></pm-charts>
            <div class="footerBorder"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PmCharts from '@/components/homeComponents/pmCharts'
import SiteMap from '@/components/homeComponents/siteMap'
import SurroundingsData from '@/components/homeComponents/surroundingsData'
import AlarmShow from '@/components/homeComponents/alarmShow'
import { closeWebsocket, sendWebsocket } from '@/utils/socket'
import http from '@/utils/http'
export default {
  name: 'home',
  components: { AlarmShow, SurroundingsData, SiteMap, PmCharts },
  data () {
    return {
      alarmDialog: false,
      warningInfo: {
      }
    }
  },
  created () {
    http.get('/Indeex/get').then(resp => {
      this.$refs.surroundingsData.getData(resp.data.environment[0])
      this.$refs.siteMap.getData(resp.data.hardware)
      this.$refs.alarmShow.getData(resp.data.warningrecord)
    })
    closeWebsocket()
    // 跟后端协商，需要什么参数数据给后台
    const obj = 'hello'
    // 发起ws请求
    sendWebsocket('ws://10.147.20.74:2001/websocket/home', obj, this.wsMessage, this.wsError)
  },
  beforeDestroy () {
    closeWebsocket()
  },
  methods: {
    wsMessage (data) {
      console.log(data)
      // 这里写拿到数据后的业务代码
      if (data.warning !== undefined) {
        this.alarmDialog = true
        this.warningInfo = data.warning
      }
      if (data.environment !== undefined) {
        this.$refs.surroundingsData.getEnvironmentData(data.environment)
      }
    },
    // ws连接失败，组件要执行的代码
    wsError () {
      // 比如取消页面的loading
    }
  }
}
</script>

<style scoped lang="less">
.bodyContainer {
  min-width: 1024px;
  max-width: 1920px;
  height: 100%;
  padding: 30px 120px 0 120px;
  display: flex;
  .leftContainer {
    width: 500px;
    .surroundingChart {
      width: 450px;
      height: 340px;
    }
    .alarmShow {
      width: 450px;
      height: 180px;
      margin-top: 25px;
    }
  }
  .rightContainer {
    flex: 4;
    padding-left: 20px;
    .siteMap {
      width: 800px;
      height: 390px;
    }
    .Chart {
      width: 800px;
      height: 130px;
      margin-top: 25px;
    }
  }
}
/deep/.el-dialog, .el-pager li {
  background-image: radial-gradient(rgba(241, 37, 37, 0.75),rgba(255,63,45,0.75));
}
/deep/.el-dialog__title {
  color: #30eee9;
}
/deep/.el-dialog__body {
  color: #30eee9;
}
</style>

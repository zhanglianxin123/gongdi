<template>
<!--开关控制-->
  <div>
    <div class="bodyContainer" v-if="switchSetting[0]">
      <div class="box">
<!--        粉尘报警器-->
        <div class="box1 boxBorder">
          <switch-setting :switchSetting="switchSetting[6]"></switch-setting>
          <div class="footerBorder"></div>
        </div>
<!--        吊塔震动报警器-->
        <div class="box1 boxBorder" style="margin-top: 25px">
          <switch-setting :switchSetting="switchSetting[0]"></switch-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
      <div class="box">
        <!--        喷淋开关-->
        <div class="box1 boxBorder">
          <switch-setting :switchSetting="switchSetting[7]"></switch-setting>
          <div class="footerBorder"></div>
        </div>
<!--        吊塔三轴报警器-->
        <div class="box1 boxBorder" style="margin-top: 25px">
          <switch-setting :switchSetting="switchSetting[3]"></switch-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
      <div class="box">
        <!--        噪音报警器-->
        <div class="box1 boxBorder">
          <switch-setting :switchSetting="switchSetting[2]"></switch-setting>
          <div class="footerBorder"></div>
        </div>
        <!--        高支模震动报警器-->
        <div class="box1 boxBorder" style="margin-top: 25px">
          <switch-setting :switchSetting="switchSetting[1]"></switch-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
      <div class="box">
        <div class="box1 boxBorder">
          <switch-setting :switchSetting="switchSetting[5]"></switch-setting>
          <div class="footerBorder"></div>
        </div>
        <!--        高支模三轴报警器-->
        <div class="box1 boxBorder" style="margin-top: 25px">
          <switch-setting :switchSetting="switchSetting[4]"></switch-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
<!--      历史报警信息-->
      <div class="box alarmInfo" style="margin: 0">
        <div class="title"><span class="fontStyleItalics">历史报警信息</span></div>
        <div class="tableContainer">
          <el-table
            :data="alarmInfoTableData"
            empty-text="暂无报警信息"
            :header-cell-style="{borderColor: '#30eee9'}"
            height="480px"
            :show-header="false"
            style="width: 100%">
            <el-table-column
              prop="warning_time"
              :show-overflow-tooltip="true"
              label="时间"
              align="center"
              width="160">
            </el-table-column>
            <el-table-column
              prop="warning_name"
              label="地点"
              align="center"
              width="100">
            </el-table-column>
            <el-table-column
              :show-overflow-tooltip="true"
              prop="warning_why"
              align="center"
              label="原因">
            </el-table-column>
          </el-table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SwitchSetting from '@/components/switchComponents/switchSetting'
import http from '@/utils/http'
export default {
  name: 'switchControl',
  components: { SwitchSetting },
  data () {
    return {
      switchSetting: [],
      //  报警信息表格数据
      alarmInfoTableData: []
    }
  },
  created () {
    http.get('/switch/switchList').then(resp => {
      this.switchSetting = resp.data
    })
    http.get('/switch/getWarning').then(resp => {
      this.alarmInfoTableData = resp.data
    })
  }
}
</script>

<style scoped lang="less">
.bodyContainer {
  width: 95%;
  height: 550px;
  position: absolute;
  left: 2.5%;
  top: 170px;
  display: flex;
  .box {
    width: 240px;
    margin-right: 25px;
    .box1 {
      width: 240px;
      height: 130px;
    }
  }
  .alarmInfo {
    width: 380px;
    .title {
      height: 30px;
      span {
        font-size: 22px;
        line-height: 30px;
        color: #30eee9;
      }
    }
  }
}
//  表格样式
/deep/.el-table{
  color: #d0d09e;
  .el-button {
    color: #02a6b5;
  }
  thead {
    color: #0652DD;
  }
  th {
    background-color: rgb(4, 25, 63);
  }
  tr{
    background-color: rgb(4, 25, 63);
  }
}
/deep/.el-table, .el-table__expanded-cell {
  background-color: rgb(4, 25, 63);
}
// 修改表格最底部边框颜色和高度
.el-table::before{
  height: 1px;
  background-color: #30eee9;
}
//  修改行内线的颜色
/deep/.el-table td,.building-top .el-table th.is-leaf {
  border-bottom:  1px solid #30eee9;
}
//  修改表格鼠标悬浮hover背景色
/deep/.el-table--enable-row-hover .el-table__body tr:hover>td {
  background-color: rgb(4, 25, 63);
}
//  修改表格无数据的时候背景，字体颜色
.el-table__empty-block{
  background-color: rgb(4, 25, 63);
}
.el-table__empty-text{
  color: #02a6b5;
  font-size: 22px;
}
</style>

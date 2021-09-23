<template>
<!--  阈值管理-->
  <div class="bodyContainer">
    <div class="leftContainer" v-if="setting[0]">
      <div class="Container">
<!--        吊塔x轴加速度-->
        <div class="box1 boxBorder">
          <threshold-setting :setting="setting[0]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
<!--        高支模x轴加速度-->
        <div class="box2 boxBorder">
          <threshold-setting :setting="setting[5]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
      <div class="Container">
<!--        吊塔Y轴加速度-->
        <div class="box1 boxBorder">
          <threshold-setting :setting="setting[1]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
<!--        高支模Y轴加速度-->
        <div class="box2 boxBorder">
          <threshold-setting :setting="setting[6]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
      <div class="Container">
<!--        吊塔z轴加速度-->
        <div class="box1 boxBorder">
          <threshold-setting :setting="setting[2]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
<!--        高支模Z轴加速度-->
        <div class="box2 boxBorder">
          <threshold-setting :setting="setting[7]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
      <div class="Container">
<!--        粉尘一号-->
        <div class="box1 boxBorder">
          <threshold-setting :setting="setting[3]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
<!--        噪音-->
        <div class="box2 boxBorder">
          <threshold-setting :setting="setting[8]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
      <div class="Container">
<!--        粉尘二号-->
        <div class="box1 boxBorder">
          <threshold-setting :setting="setting[4]"></threshold-setting>
          <div class="footerBorder"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ThresholdSetting from '@/components/thresholdComponents/thresholdSetting'
import http from '@/utils/http'
export default {
  name: 'thresholdManagement',
  components: { ThresholdSetting },
  data () {
    return {
      setting: []
    }
  },
  created () {
    http.get('/limit/getList').then(resp => {
      this.setting = resp.data
    })
  }
}
</script>

<style scoped lang="less">
.bodyContainer {
  width: 99%;
  height: 500px;
  margin-top: 20px;
  position: absolute;
  left: 0.5%;
  .leftContainer {
    height: 390px;
    width: 100%;
    position: relative;
    top: 80px;
    left: 5px;
    display: flex;
    .Container {
      width: 280px;
      height: 370px;
      margin: 10px;
      .box1 {
        width: 280px;
        height: 160px;
        .headerStyle {
          font-size: 20px;
          position: relative;
          left: 60px;
          top: 10px;
        }
        .warningValue {
          position: relative;
          top: 25px;
          left: 20px;
          span {
            font-size: 20px;
            margin-right: 10px;
          }
        }
        .alarmValue {
          position: relative;
          top: 50px;
          left: 20px;
          span {
            font-size: 20px;
            margin-right: 10px;
          }
        }
      }
      .box2 {
        width: 280px;
        height: 160px;
        margin-top: 50px;
        .headerStyle {
          font-size: 20px;
          position: relative;
          left: 60px;
          top: 10px;
        }
        .warningValue {
          position: relative;
          top: 25px;
          left: 20px;
          span {
            font-size: 20px;
            margin-right: 10px;
          }
        }
        .alarmValue {
          position: relative;
          top: 50px;
          left: 20px;
          span {
            font-size: 20px;
            margin-right: 10px;
          }
        }
      }
    }
  }
}
</style>

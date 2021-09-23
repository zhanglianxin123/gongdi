<template>
  <div>
    <div class="headerStyle fontStyleItalics">{{title}}阈值设置</div>
    <div class="warningValue">
      <span class="fontStyleItalics">预警值</span>
      <el-input-number @change="getMinValue" v-model="minValue" :precision="precision" :step="setStep" :min="0" :max="100" size="mini"></el-input-number>
      <span class="unitContainer fontStyleItalics">{{unit}}</span>
    </div>
    <div class="alarmValue">
      <span class="fontStyleItalics">报警值</span>
      <el-input-number @change="getMaxValue" v-model="maxValue" :precision="precision" :step="setStep" :min="0" :max="100" size="mini"></el-input-number>
      <span class="unitContainer fontStyleItalics">{{unit}}</span>
    </div>
  </div>
</template>

<script>
import http from '@/utils/http'

export default {
  name: 'thresholdSetting',
  props: ['setting'],
  created () {
    if (this.setting.precision > 0) {
      this.setStep = this.setStep / Math.pow(10, this.setting.precision)
    }
  },
  data () {
    return {
      title: this.setting.device_name, //  阈值名
      unit: this.setting.unit, //  单位
      maxValue: this.setting.max_value, //  报警值
      minValue: this.setting.min_value, //  预警值
      precision: this.setting.precision, //  精度
      setStep: 1 //  计数器步长
    }
  },
  methods: {
    getMinValue (currentValue) {
      http.post('/limit/updateMin', { device_id: this.setting.device_id, value: currentValue }).then(resp => {
        this.$message.success('修改' + resp.message)
      })
    },
    getMaxValue (currentValue) {
      http.post('/limit/updateMax', { device_id: this.setting.device_id, value: currentValue }).then(resp => {
        this.$message.success('修改' + resp.message)
      })
    }
  }
}
</script>

<style scoped lang="less">
.headerStyle {
  font-size: 20px;
  position: relative;
  text-align: center;
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
  .unitContainer {
    margin-left: 10px;
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
  .unitContainer {
    margin-left: 10px;
  }
}
/deep/.el-input__inner {
  background-color: transparent;
  border-color: #30eee9;
  color: #d0d09e;
}
/deep/.el-input-number__decrease, /deep/.el-input-number__increase {
  background: transparent;
  color: #30eee9;
  border-color: #30eee9;
}
</style>

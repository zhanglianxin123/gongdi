<template>
  <div>
    <div class="title fontStyleItalics">{{ title }}开关</div>
    <div class="switchBox">
      <span class="fontStyleItalics">报警开关</span>
      <el-switch
        v-model="switchSetting.switch_state"
        @change="getState"
        :active-value = 1
        :inactive-value = 0
        inactive-color="#6261ba"
        active-color="#EFB139FF">
      </el-switch>
    </div>
  </div>
</template>

<script>
import http from '@/utils/http'

export default {
  name: 'switchSetting',
  props: ['switchSetting'],
  data () {
    return {
      title: this.switchSetting.switch_name
    }
  },
  methods: {
    getState (state) {
      http.post('/switch/update', { switch_id: this.switchSetting.switch_id, switch_state: state }).then(resp => {
        if (state === 1) {
          this.$message.success('开启' + resp.message)
        }
        if (state === 0) {
          this.$message.success('关闭' + resp.message)
        }
      })
    }
  }
}
</script>

<style scoped lang="less">
.title {
  font-size: 20px;
  text-align: center;
  top: 10px;
  position: relative
}
.switchBox {
  position: relative;
  top: 30px;
  text-align: center;
  span {
    color: rgba(54,133,255,0.75);
    font-size: 20px;
    margin-right: 20px
  }
}
/deep/.el-switch__core:after {
  background-color: #9880fd;
}
</style>

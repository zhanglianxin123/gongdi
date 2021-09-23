<template>
  <div>
<!--选择器组件-->
    <el-select v-model="optionsData.data" :placeholder="placeholder">
      <el-option
        v-for="item in options"
        @click.native="putLabel(item)"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
  </div>
</template>

<script>
export default {
  name: 'selectComponents',
  props: ['optionsData'],
  data () {
    return {
      placeholder: this.optionsData.placeholder,
      options: this.optionsData.info,
      listenSelectName: this.optionsData.listenSelectName,
      selectLabel: ''
    }
  },
  methods: {
    //  向父组件发送数据
    putLabel (data) {
      this.$emit(this.listenSelectName, data)
    }
  }
}
</script>

<style scoped lang="less">

</style>

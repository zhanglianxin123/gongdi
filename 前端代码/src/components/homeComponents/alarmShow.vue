<template>
  <div class="boxContainer">
    <div class="title"><span class="fontStyleItalics">最新报警信息</span></div>
    <el-divider></el-divider>
    <div v-for="item of alarmInfoData" :key="item.id">
      <div class="info fontStyleItalics">
        <div>{{item.warning_time}}</div>
        <div style="width: 100px">{{item.warning_name}}</div>
        <div class="warningWhy" :title="item.warning_why">{{item.warning_why}}</div>
      </div>
      <el-divider></el-divider>
    </div>
  </div>
</template>

<script>
export default {
  name: 'alarmShow',
  data () {
    return {
      alarmInfoData: []
    }
  },
  methods: {
    getData (data) {
      this.alarmInfoData = data
    }
  }
}
</script>

<style scoped lang="less">
.boxContainer {
  width: 450px;
  height: 180px;
  .title {
    height: 30px;
    span {
      font-size: 22px;
      line-height: 30px;
      margin-left: 20px;
      color: #30eee9;
    }
  }
  .info {
    height: 20px;
    display: flex;
    div {
      font-size: 16px;
      line-height: 20px;
      color: #686de0;
      width: 175px;
      text-align: center;
    }
    .warningWhy {
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
  }
  .el-divider {
    margin: 0;
    background-color: #02a6b5;
  }
}
</style>

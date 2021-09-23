<template>
<!--  展示当前天气、时间、温度、风速、噪音、粉尘-->
  <div class="card">
<!--    标题-->
    <div class="titleContainer">
      <span class="fontStyleItalics">工地信息</span>
    </div>
<!--    数据-->
    <div class="dataContainer">
      <el-row>
        <el-col :span="12">
          <div class="dataBox" style="margin-top: 0"><pre>工地名: 江西理工大学</pre></div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="dataBox" style="margin-top: 0"><pre>负责人: 胡雨圣</pre></div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="dataBox" style="margin-top: 0"><pre>地址: 江西省赣州市章贡区客家大道156号</pre></div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div class="dataBox" style="margin-top: 0;margin-bottom: 20px"><pre>工地人数: 156人</pre></div>
        </el-col>
      </el-row>
      <div class="titleContainer">
        <span class="fontStyleItalics">环境数据</span>
      </div>
      <el-row>
        <el-col :span="12">
          <div class="dataBox" style="margin-top: 0"><pre>粉尘:&nbsp;&nbsp;{{dust_one}}&nbsp;&nbsp;ug/m³</pre></div>
        </el-col>
        <el-col :span="12">
          <div class="dataBox" style="margin-top: 0"><pre>噪音:&nbsp;&nbsp;{{noise}}&nbsp;&nbsp;dB</pre></div>
        </el-col>
      </el-row>
      <div class="dataBox"><pre>风速:&nbsp;&nbsp;{{speed}}&nbsp;&nbsp;m/s</pre></div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'surroundingsData',
  data () {
    return {
      dust_one: '',
      noise: '',
      speed: ''
    }
  },
  created () {
  },
  methods: {
    getData (data) {
      this.dust_one = data.dust_one
      this.noise = data.noise
      this.speed = data.speed
    },
    getEnvironmentData (data) {
      this.dust_one = data.dust_one
      this.noise = data.noise
      this.speed = data.speed
    }
  }
}
</script>

<style scoped lang="less">
.card {
  height: 100%;
  width: 100%;
  .titleContainer {
    height: 50px;
    span {
      font-size: 22px;
      line-height: 50px;
      margin-left: 20px;
      color: #30eee9;
    }
  }
  .dataContainer {
    height: 250px;
    .dataBox {
      height: 30px;
      line-height: 30px;
      margin-top: 15px;
      margin-left: 30px;
      color: #686de0;
      font-size: 20px;
      pre {
        font-family: 'KaiTi', serif;
        margin: 0;
      }
    }
    .speedBox {
      height: 145px;
      .accelerationCard {
        width: 160px;
        height: 100px;
        margin-left: 35px;
        margin-top: 10px;
      }
    }
  }
}
</style>

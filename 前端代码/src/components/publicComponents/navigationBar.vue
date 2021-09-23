<template>
<!--标题与导航栏-->
  <div class="Container">
    <div class="headerContainer">
      <img style="height: 110px" src="../../assets/globalImages/建筑工地安全管控系统.png" alt="图片加载中">
      <div class="userContainer">
        <div class="weatherBox"><weather></weather></div>
        <div class="signOut"><img src="../../assets/globalImages/退出.png" alt="图片加载中" @click="signOut"></div>
      </div>
    </div>
    <!--      导航栏-->
    <div class="navContainer">
      <div class="navImgContainer">
        <img id="1" :class="{imgWidth: currentHome===current}" src="../../assets/globalImages/首页.png" alt="" @click="toHome">
        <img id="2" :class="{imgWidth: currentThresholdManagement===current}" src="../../assets/globalImages/阈值管理.png" alt="" @click="toThresholdManagement">
        <img id="3" :class="{imgWidth: currentSwitchControl===current}" src="../../assets/globalImages/开关控制.png" alt="" @click="toSwitchControl">
        <img id="4" :class="{imgWidth: currentPersonnelManagement===current}" src="../../assets/globalImages/人员管理.png" alt="" @click="toPersonnelManagement">
        <img id="5" :class="{imgWidth: currentSiteManagement===current}" style="margin-left: 360px" src="../../assets/globalImages/工地管理.png" alt="" @click="toSiteManagement">
        <img id="6" :class="{imgWidth: currentSafeLearning===current}" src="../../assets/globalImages/安全学习.png" alt="" @click="toSafeLearning">
        <img id="7" :class="{imgWidth: currentSignManagement===current}" src="../../assets/globalImages/签到管理.png" alt="" @click="toSignManagement">
        <a href="http://localhost:6081" target="_blank"><img id="8" src="../../assets/globalImages/安全帽.png" alt=""></a>
      </div>
    </div>
  </div>
</template>

<script>
import Weather from '@/components/publicComponents/weather'
export default {
  name: 'navigationBar',
  components: { Weather },
  data () {
    return {
      current: 0,
      currentHome: 1,
      currentThresholdManagement: 2,
      currentSwitchControl: 3,
      currentPersonnelManagement: 4,
      currentSiteManagement: 5,
      currentSafeLearning: 6,
      currentSignManagement: 7
    }
  },
  created () {
    if (this.$route.path === '/home') {
      this.current = 1
    }
    if (this.$route.path === '/thresholdManagement') {
      this.current = 2
    }
    if (this.$route.path === '/switchControl') {
      this.current = 3
    }
    if (this.$route.path === '/personnelManagement') {
      this.current = 4
    }
    if (this.$route.path === '/siteManagement') {
      this.current = 5
    }
    if (this.$route.path === '/safeLearning') {
      this.current = 6
    }
    if (this.$route.path === '/signManagement') {
      this.current = 7
    }
  },
  watch: {
    $route: {
      handler () {
        if (this.$route.path === '/home') {
          this.current = 1
        }
        if (this.$route.path === '/thresholdManagement') {
          this.current = 2
        }
        if (this.$route.path === '/switchControl') {
          this.current = 3
        }
        if (this.$route.path === '/personnelManagement') {
          this.current = 4
        }
        if (this.$route.path === '/siteManagement') {
          this.current = 5
        }
        if (this.$route.path === '/safeLearning') {
          this.current = 6
        }
        if (this.$route.path === '/signManagement') {
          this.current = 7
        }
      }
    }
  },
  methods: {
    //  回到首页
    toHome () {
      this.current = 1
      if (this.$route.name !== 'home') {
        this.$router.push('/home')
      }
    },
    //  阈值管理
    toThresholdManagement () {
      this.current = 2
      this.$router.push('/thresholdManagement')
    },
    //  开关控制
    toSwitchControl () {
      this.current = 3
      this.$router.push('/switchControl')
    },
    //  人员管理
    toPersonnelManagement () {
      this.current = 4
      this.$router.push('personnelManagement')
    },
    //  工地管理
    toSiteManagement () {
      this.current = 5
      this.$router.push('siteManagement')
    },
    //  安全学习
    toSafeLearning () {
      this.current = 6
      this.$router.push('safeLearning')
    },
    //  签到管理
    toSignManagement () {
      this.current = 7
      this.$router.push('signManagement')
    },
    signOut () {
      window.localStorage.clear()
      this.$router.push('/')
    }
  }
}
</script>

<style scoped lang="less">
.Container {
  min-width: 1024px;
  max-width: 1920px;
  height: 100%;
  .headerContainer {
    margin-left: 28%;
    height: 90px;
    display: flex;
    .userContainer {
      width: 250px;
      height: 40px;
      position: absolute;
      right: 20px;
      top: 15px;
      display: flex;
      .signOut {
        img {
          cursor: pointer;
          width: 50px;
          height: 25px;
          position: relative;
          top: 50%;
          transform: translateY(-50%);
        }
      }
      .weatherBox {
        cursor:not-allowed;
        pointer-events:none;
        width: 200px;
      }
    }
    img {
      width: 650px;
    }
  }
  .navContainer {
    min-width: 1500px;
    max-width: 1920px;
    display: flex;
    padding: 0 5px;
    margin-top: -15px;
    .navImgContainer {
      height: 40px;
      img {
        width: 100px;
        margin-left: 40px;
        cursor: pointer;
      }
      .imgWidth {
        width: 120px;
      }
    }
  }
}
</style>

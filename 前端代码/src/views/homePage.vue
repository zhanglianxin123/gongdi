<template>
  <div>
<!--    显示功能页面-->
    <navigation-bar></navigation-bar>
    <router-view></router-view>
  </div>
</template>

<script>
import NavigationBar from '@/components/publicComponents/navigationBar'
export default {
  name: 'homePage',
  components: { NavigationBar }
}
</script>

<style scoped>

</style>

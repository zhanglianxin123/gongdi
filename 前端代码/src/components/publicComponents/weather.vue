<template>
  <div>
    <div id="he-plugin-simple"></div>
  </div>
</template>

<script>
export default {
  name: 'weather',
  data () {
    return {}
  },
  created () {
    window.WIDGET = {
      CONFIG: {
        modules: '01234',
        background: '5',
        tmpColor: '02A6B5',
        tmpSize: '16',
        cityColor: '02A6B5',
        citySize: '16',
        aqiColor: '02A6B5',
        aqiSize: '16',
        weatherIconSize: '24',
        alertIconSize: '18',
        padding: '10px 10px 10px 10px',
        shadow: '0',
        language: 'auto',
        fixed: 'false',
        vertical: 'top',
        horizontal: 'left',
        key: 'add3238855c44c72b64e84c78780bbba'
      }
    }
    const script = document.createElement('script')
    script.type = 'text/javascript'
    script.src = 'https://widget.qweather.net/simple/static/js/he-simple-common.js?v=2.0'
    document.getElementsByTagName('head')[0].appendChild(script)
  },
  methods: {}
}
</script>

<style scoped lang="less">

</style>

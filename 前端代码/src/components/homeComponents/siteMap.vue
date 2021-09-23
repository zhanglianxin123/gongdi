<template>
  <div>
    <div :id="map" style="width: 800px;height: 390px"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import siteMap from '../../assets/map/建筑工地平面图.json'
export default {
  name: 'siteMap',
  data () {
    return {
      map: 'siteMapID',
      charts: null,
      accelerationData: [
        {
          name: '吊塔',
          value: [
            { name: 'X轴加速度', value: 0 },
            { name: 'Y轴加速度', value: 0 },
            { name: 'Z轴加速度', value: 0 }
          ]
        },
        {
          name: '高支模',
          value: [
            { name: 'X轴加速度', value: 0 },
            { name: 'Y轴加速度', value: 0 },
            { name: 'Z轴加速度', value: 0 }
          ]
        }
      ]
    }
  },
  beforeDestroy () {
    if (!this.charts) {
      return ''
    }
    this.charts.dispose()
    this.charts = null
  },
  mounted () {
    this.initCharts()
  },
  methods: {
    getData (data) {
      this.accelerationData[0].value[0].value = data[0].acceleration_x_one
      this.accelerationData[0].value[1].value = data[0].acceleration_y_one
      this.accelerationData[0].value[2].value = data[0].acceleration_z_one
      this.accelerationData[1].value[0].value = data[0].acceleration_x_two
      this.accelerationData[1].value[1].value = data[0].acceleration_y_two
      this.accelerationData[1].value[2].value = data[0].acceleration_z_two
    },
    initCharts () {
      this.charts = echarts.init(document.getElementById(this.map))
      echarts.registerMap('siteMap', siteMap)
      const option = {
        //  鼠标移入图形时，显示的标签
        title: {
          show: true,
          text: '建筑工地平面图',
          x: 'center',
          textStyle: {
            color: '#30eee9',
            fontWeight: 'normal',
            fontFamily: 'KaiTi',
            fontSize: 22
          }
        },
        tooltip: {
          trigger: 'item',
          backgroundColor: 'rgba(191, 208, 214)',
          borderColor: '#00d2d4',
          textStyle: {
            color: '#6c5ce7',
            fontFamily: 'KaiTi',
            fontSize: 16
          },
          formatter: function (params) {
            const data = option.series[0].data
            let res = params.name + '<br/>'
            for (let i = 0; i < data.length; i++) {
              if (data[i].name === params.name) {
                for (let j = 0; j < data[i].value.length; j++) {
                  res += data[i].value[j].name + ' :&nbsp&nbsp&nbsp' + data[i].value[j].value + ' g' + '<br/>'
                }
              }
            }
            return res
          }
        },
        series: [{
          name: '数据展示', //  鼠标移入地图区域时标签头
          map: 'siteMap',
          type: 'map',
          zoom: 1.1,
          top: '15%',
          label: {
            show: true,
            color: '#02a6b5',
            fontWeight: 'bold',
            fontSize: 16,
            fontFamily: 'KaiTi'
          },
          //  选中地图区域的颜色
          select: {
            itemStyle: {
              areaColor: '#00d2d4'
            }
          },
          itemStyle: {
            normal: {
              borderWidth: 1, // 边际线大小
              borderColor: '#00ffff', // 边界线颜色
              // 默认区域颜色
              areaColor: {
                type: 'linear',
                x: 0,
                y: 0,
                x2: 1,
                y2: 0,
                colorStops: [{
                  offset: 0, color: '#6c6d6e' // 0% 处的颜色
                }, {
                  offset: 0.5, color: '#bfd0d6' // 100% 处的颜色
                }],
                global: false // 缺省为 false
              }
            },
            emphasis: {
              show: true,
              areaColor: '#27b4c2', // 鼠标滑过区域颜色
              label: {
                show: true,
                textStyle: {
                  color: '#fff'
                }
              }
            }
          },
          data: this.accelerationData
        }]
      }
      this.charts.setOption(option)
    }
  }
}
</script>

<style scoped lang="less">

</style>

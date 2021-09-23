<template>
  <div>
    <div :id="pmChart" style="height: 130px;width: 800px"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
export default {
  name: 'pmCharts',
  data () {
    return {
      charts: null,
      pmChart: 'chartsId'
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
    initCharts () {
      this.charts = echarts.init(document.getElementById(this.pmChart))
      const fontColor = '#30eee9'
      //  粉尘实时浓度数据
      const pmData = [12, 13, 10, 34, 90, 30, 20, 82, 11, 34, 90, 33]
      //  噪音实时浓度数据
      const noiseData = [22, 82, 11, 23, 29, 30, 30, 12, 14, 19, 33, 10]
      const options = {
        title: {
          show: true,
          text: '粉尘与噪音实时数据',
          x: 'center',
          textStyle: {
            color: '#30eee9',
            fontWeight: 'normal',
            fontFamily: 'KaiTi',
            fontSize: 22
          }
        },
        grid: {
          left: '15%',
          right: '10%',
          top: '25%',
          bottom: '15%'
          // containLabel: true
        },
        tooltip: {
          show: true,
          trigger: 'item'
        },
        legend: {
          left: '70%',
          show: true,
          icon: 'stack',
          itemWidth: 10,
          itemHeight: 10,
          textStyle: {
            color: '#1bb4f6'
          },
          data: ['粉尘', '噪音']
        },
        xAxis: [{
          type: 'category',
          boundaryGap: false,
          axisLabel: {
            color: fontColor
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: '#397cbc'
            }
          },
          axisTick: {
            show: false
          },
          splitLine: {
            show: false,
            lineStyle: {
              color: '#195384'
            }
          },
          data: ['7点', '8点', '9点', '10点', '11点', '12点', '13点', '14点', '15点', '16点', '18点', '19点']
        }],
        yAxis: [{
          type: 'value',
          name: '',
          min: 0,
          max: 100,
          axisLabel: {
            formatter: '{value}',
            textStyle: {
              color: '#2ad1d2'
            }
          },
          axisLine: {
            lineStyle: {
              color: '#27b4c2'
            }
          },
          axisTick: {
            show: false
          },
          splitLine: {
            show: true,
            lineStyle: {
              color: '#11366e'
            }
          }
        }],
        series: [{
          name: '粉尘',
          type: 'line',
          symbol: 'circle',
          symbolSize: 8,
          itemStyle: {
            normal: {
              color: '#0092f6',
              lineStyle: {
                color: '#0092f6',
                width: 1
              }
            }
          },
          markPoint: {
            itemStyle: {
              normal: {
                color: '#0092f6'
              }
            }
          },
          data: pmData
        },
        {
          name: '噪音',
          type: 'line',
          symbol: 'circle',
          symbolSize: 8,
          itemStyle: {
            normal: {
              color: '#00d4c7',
              lineStyle: {
                color: '#00d4c7',
                width: 1
              }
            }
          },
          data: noiseData
        }]
      }
      this.charts.setOption(options)
    }
  }
}
</script>

<style scoped lang="less">

</style>

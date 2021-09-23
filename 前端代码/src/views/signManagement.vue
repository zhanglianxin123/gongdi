<template>
<!--签到管理-->
  <div class="bodyContainer">
    <div class="signContainer boxBorder">
      <div class="title fontStyleItalics">签到人员</div>
      <div class="boxBorder fontStyleItalics headerContainer">
        <div style="width: 70px">工号</div>
        <div style="width: 100px">姓名</div>
        <div style="width: 160px">签到时间</div>
        <div class="footerBorder"></div>
      </div>
      <div class="boxBorder fontStyleItalics signPersonBox" v-for="item in signPerson" v-bind:key="item.id">
        <div style="width: 70px">{{item.user_id}}</div>
        <div style="width: 100px">{{item.user_name}}</div>
        <div style="width: 160px">{{item.sign_time}}</div>
        <div class="footerBorder"></div>
      </div>
      <div class="footerBorder"></div>
    </div>
    <div class="historySignContainer">
      <el-tabs type="border-card">
        <el-tab-pane label="按时间查询签到" style="text-align: center;">
          <div class="queryDate">
            <el-date-picker
              v-model="dateValue"
              value-format="yyyy-MM-dd"
              type="date"
              @change="getDate"
              placeholder="选择日期">
            </el-date-picker>
          </div>
          <div class="signNumberTable">
            <el-table
              :empty-text="dateMessage"
              :header-cell-style="{borderColor: '#30eee9'}"
              :data="signDateTableData"
              style="width: 600px;">
              <el-table-column
                align="center"
                prop="user_id"
                width="120"
                label="工号">
              </el-table-column>
              <el-table-column
                align="center"
                prop="user_name"
                width="100"
                label="姓名">
              </el-table-column>
              <el-table-column
                align="center"
                prop="construction_name"
                width="200"
                label="工地名">
              </el-table-column>
              <el-table-column
                align="center"
                prop="sign_time"
                label="签到时间">
              </el-table-column>
            </el-table>
          </div>
          <div class="Pagination">
            <el-pagination
              background
              :page-size="6"
              @current-change="currentDatePage"
              :hide-on-single-page="isHide"
              layout="prev, pager, next"
              :total="personNumber">
            </el-pagination>
          </div>
        </el-tab-pane>
        <el-tab-pane label="按姓名查询签到">
          <div class="queryContainer">
            <el-form :inline="true" :model="formData" class="demo-form-inline" style="text-align: center">
              <el-form-item>
                <el-input @input="clearInput" v-model="formData.ch" placeholder="请输入姓名"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="querySign">查询</el-button>
              </el-form-item>
            </el-form>
          </div>
          <div class="signNumberTable" style="margin-top: -10px;">
            <el-table
              :data="signNameTableData"
              :empty-text="nameMessage"
              style="width: 600px;">
              <el-table-column
                align="center"
                prop="user_id"
                width="120"
                label="工号">
              </el-table-column>
              <el-table-column
                align="center"
                prop="user_name"
                width="100"
                label="姓名">
              </el-table-column>
              <el-table-column
                align="center"
                prop="construction_name"
                width="200"
                label="工地名">
              </el-table-column>
              <el-table-column
                align="center"
                prop="sign_time"
                label="签到时间">
              </el-table-column>
            </el-table>
          </div>
          <div class="Pagination">
            <el-pagination
              background
              :page-size="6"
              @current-change="currentNamePage"
              :hide-on-single-page="isHide"
              layout="prev, pager, next"
              :total="personNumber">
            </el-pagination>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import http from '@/utils/http'

export default {
  name: 'signManagement',
  data () {
    return {
      isHide: true,
      personNumber: 0,
      dateMessage: '请选择日期查询数据',
      nameMessage: '请输入姓名查询数据',
      dateValue: '',
      currentDate: '',
      currentName: '',
      //  搜索个人签到数据
      formData: {
        current: 1,
        size: 6,
        ch: ''
      },
      //  签到人员数据
      signPerson: [],
      //  签到数据统计
      signNameTableData: [],
      signDateTableData: []
    }
  },
  created () {
    //  请求最近签到的数据
    http.get('/sign/getSignRecently').then(resp => {
      this.signPerson = resp.data
    })
  },
  methods: {
    //  获取当前页数
    currentDatePage (val) {
      http.post('/sign/getSelectByTime', { ch: this.currentDate, current: val, size: 6 }).then(resp => {
        this.signDateTableData = resp.data.list
      })
    },
    currentNamePage (val) {
      http.post('/sign/getSelectByName', { ch: this.currentName, current: val, size: 6 }).then(resp => {
        this.signNameTableData = resp.data.list
      })
    },
    //  获取查询的日期
    getDate (val) {
      this.currentDate = val
      if (val !== null) {
        http.post('/sign/getSelectByTime', { ch: val, current: 1, size: 6 }).then(resp => {
          if (resp.data.size === 0) {
            this.$message.warning('当天无人签到')
          } else {
            if (resp.data.size > 6) {
              this.isHide = false
            }
            this.personNumber = resp.data.size
            this.signDateTableData = resp.data.list
          }
        })
      } else {
        this.signDateTableData = []
      }
    },
    querySign () {
      this.currentName = this.formData.ch
      http.post('/sign/getSelectByName', this.formData).then(resp => {
        if (resp.data.list.length === 0) {
          this.$message.error('没有此人，请重新查询')
        } else {
          if (resp.data.size > 6) {
            this.isHide = true
          }
          this.personNumber = resp.data.size
          this.signNameTableData = resp.data.list
        }
      })
    },
    clearInput (val) {
      if (val === '') {
        this.signNameTableData = []
      }
    }
  }
}
</script>

<style scoped lang="less">
.bodyContainer {
  width: 95%;
  height: 500px;
  margin-top: 30px;
  position: absolute;
  left: 2.5%;
  display: flex;
  //  最近签到盒子样式
  .signContainer {
    width: 330px;
    height: 500px;
    margin-right: 30px;
    margin-top: 25px;
    .boxBorder {
      height: 30px;
      text-align: center;
    }
    //  最近签到人数标题样式
    .title {
      font-size: 24px;
      width: 100%;
      height: 40px;
      text-align: center;
      margin-top: 10px;
    }
    //  最近签到人数表格标题样式
    .headerContainer {
      display: flex;
      font-size: 20px;
      height: 30px;
      text-align: center;
      line-height: 30px;
    }
    //  最近签到人数样式
    .signPersonBox {
      display: flex;
      text-align: center;
      line-height: 30px
    }
  }
  .historySignContainer {
    width: 1080px;
    height: 500px;
    margin-top: 25px;
    .queryDate {
      /deep/.el-input__inner {
        background-color: transparent;
        border-color: #30eee9;
        color: #d0d09e;
        &::placeholder {
          color: #d0d09e;
        }
      }
      /deep/.el-input__prefix, /deep/.el-input__suffix {
        color: #d0d09e;
      }
    }
    .queryContainer {
      //  输入框样式
      /deep/.el-input__inner{
        width: 160px;
        background-color: transparent;
        border-color: #30eee9;
        color: #30eee9;
        &::placeholder {
          color: #d0d09e;
        }
      }
      .el-button--primary {
        background-color: #0fbcf9;
        color: #0652DD;
      }
    }
    .signNumberTable {
      height: 300px;
      margin-top: 10px;
      .el-table {
        margin: 0 auto;
      }
    }
    //  分页器样式
    .Pagination {
      position: absolute;
      bottom: 20px;
      left: 50%;
      transform: translateX(-50%);
    }
    .el-tabs {
      height: 500px;
      .el-tab-pane {
        height: 430px;
      }
    }
  }
}
//  表格样式
/deep/.el-table{
  color: #d0d09e;
  .el-button {
    color: #02a6b5;
  }
  thead {
    color: #0652DD;
  }
  th {
    background-color: rgb(4, 25, 63);
  }
  tr{
    background-color: rgb(4, 25, 63);
  }
}
// 修改表格最底部边框颜色和高度
.el-table::before{
  height: 1px;
  background-color: #30eee9;
}
//  修改行内线的颜色
/deep/.el-table td,.building-top .el-table th.is-leaf {
  border-bottom:  1px solid #30eee9;
}
//  修改表格鼠标悬浮hover背景色
/deep/.el-table--enable-row-hover .el-table__body tr:hover>td {
  background-color: rgb(4, 25, 63);
}
//  修改表格无数据的时候背景，字体颜色
/deep/.el-table__empty-block{
  background-color: rgb(4, 25, 63);
}
/deep/.el-table__empty-text{
  color: #02a6b5;
  font-size: 18px;
}
//  分页器样式
/deep/.Pagination button,
/deep/.Pagination .el-pager li{
  background-color: transparent !important;
  color: #B4C2DC !important;
  border: 1px solid #0672C4;
}
/deep/.Pagination .el-pagination.is-background .el-pager li:not(.disabled).active {
  background-color: #0672C4 !important;
}
//  标签页样式
.el-tabs--border-card {
  background-color: transparent;
  border-color: rgb(4, 25, 63);
}
/deep/.el-tabs--border-card {
  .el-tabs__header {
    background-color: transparent;
    border-bottom: 1px solid #E4E7ED;
  }
}
/deep/.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active {
  color: #0652DD;
  background-color: transparent;
  border-right-color: #30eee9;
  border-left-color: #30eee9;
}
/deep/.el-tabs--border-card>.el-tabs__header .el-tabs__item {
  color: #706fd3;
}
/deep/.el-tabs--border-card .el-tabs__header {
  border-bottom: 1px solid #243b8b;
}
</style>

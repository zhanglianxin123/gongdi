<template>
<!--人员管理-->
  <div class="bodyContainer">
<!--    查询框-->
    <div class="queryContainer">
      <el-form :inline="true" :model="userData" class="demo-form-inline">
        <el-form-item>
          <el-input @input="clearInput" v-model="userData.ch" placeholder="请输入工号或姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="queryEmployee">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addEmployee">添加</el-button>
        </el-form-item>
      </el-form>
    </div>
<!--    表格-->
    <div class="tableContainer">
      <!--    添加员工对话框-->
      <add-employee @listenAdd = "refreshTable" ref="addEmployee"></add-employee>
      <!--      删除员工信息对话框-->
      <delete-dialog @listenDelete = "refreshTable" ref="deleteWorker"></delete-dialog>
      <!--      修改员工信息对话框-->
      <modify-employee-info ref="modifyEmployee"></modify-employee-info>
      <el-table
        :data="employeeTableData"
        empty-text="暂无工人信息"
        :header-cell-style="{borderColor: '#30eee9'}"
        style="width: 100%">
        <el-table-column
          label="工号"
          prop="user_id"
          align="center"
          width="120">
        </el-table-column>
        <el-table-column
          label="姓名"
          align="center"
          prop="user_name"
          width="80">
        </el-table-column>
        <el-table-column
          prop="sex"
          label="性别"
          align="center"
          width="60">
        </el-table-column>
        <el-table-column
          prop="id_card"
          label="身份证号"
          align="center"
          width="170">
        </el-table-column>
        <el-table-column
          prop="address"
          label="家庭住址"
          align="center"
          width="250">
        </el-table-column>
        <el-table-column
          prop="phone"
          label="电话号码"
          align="center"
          width="120">
        </el-table-column>
        <el-table-column
          prop="department_name"
          label="部门"
          align="center"
          width="80">
        </el-table-column>
        <el-table-column
          prop="role_name"
          label="职务"
          align="center"
          width="100">
        </el-table-column>
        <el-table-column
          prop="construction_name"
          label="所属工地"
          align="center">
        </el-table-column>
        <el-table-column label="操作" align="center" width="200">
          <template slot-scope="scope">
            <el-button
              size="mini"
              style="color: #686de0"
              type="text"
              @click="editEmployee(scope.$index, scope.row)">编辑</el-button>
            <el-button
              size="mini"
              type="text"
              style="color: #f9ca24"
              @click="deleteEmployee(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
<!--    分页器-->
    <div class="paginationContainer">
      <el-pagination
        background
        @current-change="currentPage"
        layout="prev, pager, next"
        :page-size="7"
        :hide-on-single-page="isHide"
        :total="personNumber">
      </el-pagination>
    </div>
  </div>
</template>

<script>

import DeleteDialog from '@/components/publicComponents/deleteDialog'
import AddEmployee from '@/components/personnelComponents/addEmployee'
import ModifyEmployeeInfo from '@/components/personnelComponents/modifyEmployeeInfo'
import http from '@/utils/http'
export default {
  name: 'personnelManagement',
  components: { ModifyEmployeeInfo, AddEmployee, DeleteDialog },
  data () {
    return {
      //  总人数
      personNumber: 0,
      //  是否隐藏
      isHide: false,
      test: {
        current: 1,
        size: 7
      },
      //  删除对话框
      deleteInfo: {
        message: '删除后将无法查看该员工的信息，确认删除？',
        deleteId: '', //  需要删除的数据
        deleteUrl: '',
        listenName: 'listenDelete'
      },
      //  查询用户数据
      userData: {
        ch: ''
      },
      //  员工表格数据
      employeeTableData: [{
        user_id: '', //  工号
        user_name: '', //  姓名
        sex: '', //  性别
        id_card: '', //  身份证号
        address: '', //  家庭住址
        phone: '', //  电话号码
        department_id: '', //  部门编号
        department_name: '', //  部门
        role_name: '', //  职务
        role_id: '', // 权限编号
        construction_name: '', //  所在工地
        construction_id: '' //  工地编号
      }]
    }
  },
  created () {
    //  查询分页
    http.post('/user2/getList/', this.test).then(resp => {
      this.employeeTableData = resp.data
    })
    //  获取总人数
    http.get('/user2/getNumber').then(resp => {
      if (resp.data <= 6) {
        this.isHide = true
      }
      this.personNumber = resp.data
    })
  },
  methods: {
    //  查询工人
    queryEmployee () {
      http.post('/user2/selectList', this.userData.ch).then(resp => {
        this.employeeTableData = resp.data
      })
    },
    clearInput (val) {
      if (val === '') {
        http.post('/user2/getList/', this.test).then(resp => {
          this.employeeTableData = resp.data
        })
      }
    },
    //  添加工人
    addEmployee () {
      this.$refs.addEmployee.openDialog()
    },
    //  修改员工信息
    editEmployee (index, row) {
      //  打开修改用户信息对话框
      this.$refs.modifyEmployee.openModifyDialog(row)
    },
    //  删除员工
    deleteEmployee (index, row) {
      this.deleteInfo.deleteId = row.user_id
      this.deleteInfo.deleteUrl = '/user2/delete/'
      this.$refs.deleteWorker.deleteDialog(this.deleteInfo)
    },
    //  获取当前的页数
    currentPage (val) {
      this.test.current = val
      http.post('/user2/getList/', this.test).then(resp => {
        this.employeeTableData = resp.data
      })
    },
    refreshTable (val) {
      if (val) {
        //  查询分页
        http.post('/user2/getList/', this.test).then(resp => {
          this.employeeTableData = resp.data
        })
      }
    }
  }
}
</script>

<style scoped lang="less">
.bodyContainer {
  margin-top: 40px;
  padding: 30px 0 30px 0;
  position: absolute;
  left: 5%;
  width: 90%;
  height: 500px;
  border-radius: 4px;
  .queryContainer {
    position: relative;
    left: 50%;
    transform: translateX(-50%);
    width: 360px;
    height: 40px;
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
  }
  .tableContainer {
    margin-top: 20px;
    position: relative;
    width: 100%;
  }
  .paginationContainer {
    width: 30%;
    position: absolute;
    left: 50%;
    bottom: 10px;
    text-align: center;
    transform: translateX(-50%);
  }
}
//  按钮样式
.el-button {
  margin-left: 30px;
}
.el-button--primary {
  background-color: #0fbcf9;
  color: #0652DD;
}
.el-form-item {
  margin-bottom: 0;
  margin-right: 0;
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
.el-table__empty-block{
  background-color: rgb(4, 25, 63);
}
.el-table__empty-text{
  color: #02a6b5;
  font-size: 22px;
}
//  分页器样式
/deep/.paginationContainer button,
/deep/.paginationContainer .el-pager li{
  background-color: transparent !important;
  color: #B4C2DC !important;
  border: 1px solid #0672C4;
}
/deep/.paginationContainer .el-pagination.is-background .el-pager li:not(.disabled).active {
  background-color: #0672C4 !important;
}
</style>

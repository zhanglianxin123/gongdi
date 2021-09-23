<template>
<!--工地管理-->
  <div class="bodyContainer">
    <div class="panel">
      <div class="centerBox">
<!--        添加工地对话框-->
        <el-dialog title="添加工地" :visible.sync="addSiteDialog" center>
          <el-form :model="addFormData" ref="addSite" label-width="80px">
            <el-row :gutter="10">
              <el-col :span="8">
                <el-form-item label="id" prop="construction_id">
                  <el-input v-model="addFormData.construction_id"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="工地编号" prop="construction_number">
                  <el-input v-model="addFormData.construction_number"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="12">
                <el-form-item label="工地名称" prop="construction_name">
                  <el-input v-model="addFormData.construction_name"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="8">
                <el-form-item label="负责人" prop="head_name">
                  <el-input v-model="addFormData.head_name"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系电话" prop="head_phone">
                  <el-input v-model="addFormData.head_phone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="12">
                <el-form-item label="工地地址" prop="construction_address">
                  <el-input v-model="addFormData.construction_address"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="8">
                <el-form-item label="工地经度" prop="construction_longitude">
                  <el-input v-model="addFormData.construction_longitude"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="工地纬度" prop="construction_latitude">
                  <el-input v-model="addFormData.construction_latitude"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="工地人数" prop="construction_people">
                  <el-input v-model="addFormData.construction_people"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="sureAddSite('addSite')">确 定</el-button>
            <el-button @click="cancelAddSite('addSite')">取 消</el-button>
          </div>
        </el-dialog>
<!--        删除工地对话框-->
        <delete-dialog @listenDeleteSite = "refreshTable" ref="deleteEmployer"></delete-dialog>
<!--        修改工地信息对话框-->
        <el-dialog title="修改信息" :visible.sync="modifySiteDialog" center>
          <el-form :model="modifyFormData" label-width="80px">
            <el-row :gutter="10">
              <el-col :span="8">
                <el-form-item label="id" prop="construction_id">
                  <el-input v-model="modifyFormData.construction_id" :disabled="true"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="工地编号" prop="construction_number">
                  <el-input v-model="modifyFormData.construction_number"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="12">
                <el-form-item label="工地名称" prop="construction_name">
                  <el-input v-model="modifyFormData.construction_name"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="8">
                <el-form-item label="负责人" prop="head_name">
                  <el-input v-model="modifyFormData.head_name"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="联系电话" prop="head_phone">
                  <el-input v-model="modifyFormData.head_phone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="12">
                <el-form-item label="工地地址" prop="construction_address">
                  <el-input v-model="modifyFormData.construction_address"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="8">
                <el-form-item label="工地经度" prop="construction_longitude">
                  <el-input v-model="modifyFormData.construction_longitude"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="工地纬度" prop="construction_latitude">
                  <el-input v-model="modifyFormData.construction_latitude"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="工地人数" prop="construction_people">
                  <el-input v-model="modifyFormData.construction_people"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="sureModifySite">确 定</el-button>
            <el-button @click="cancelModifySite">取 消</el-button>
          </div>
        </el-dialog>
        <div class="queryContainer">
          <el-form :inline="true" :model="queryEmployerData" class="demo-form-inline" style="text-align: center">
            <el-form-item>
              <el-input @input="clearInput" v-model="queryEmployerData.employer" placeholder="请输入工地编号或工地名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="queryEmployer">查询</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="addEmployer">添加</el-button>
            </el-form-item>
          </el-form>
        </div>
        <el-table
          :data="siteTableData"
          empty-text="暂无工地"
          :header-cell-style="{borderColor: '#30eee9'}"
          style="width: 1320px;">
          <el-table-column
            label="id"
            prop="construction_id"
            align="center">
          </el-table-column>
          <el-table-column
            label="工地编号"
            prop="construction_number"
            align="center"
            width="80">
          </el-table-column>
          <el-table-column
            label="工地名"
            align="center"
            prop="construction_name"
            width="180">
          </el-table-column>
          <el-table-column
            prop="head_name"
            label="负责人"
            align="center"
            width="100">
          </el-table-column>
          <el-table-column
            prop="head_phone"
            label="电话号码"
            align="center"
            width="140">
          </el-table-column>
          <el-table-column
            prop="construction_address"
            label="地址"
            align="center"
            width="250">
          </el-table-column>
          <el-table-column
            prop="construction_longitude"
            label="经度"
            align="center"
            width="100">
          </el-table-column>
          <el-table-column
            prop="construction_latitude"
            label="纬度"
            align="center"
            width="100">
          </el-table-column>
          <el-table-column
            prop="construction_people"
            label="工地人数"
            align="center">
          </el-table-column>
          <el-table-column label="操作" align="center" width="200">
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                style="color: #686de0"
                @click="modifyEmployerInfo(scope.$index, scope.row)">编辑</el-button>
              <el-button
                size="mini"
                type="text"
                style="color: #f9ca24"
                @click="deleteEmployerInfo(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import DeleteDialog from '@/components/publicComponents/deleteDialog'
import http from '@/utils/http'
export default {
  name: 'siteManagement',
  components: { DeleteDialog },
  data () {
    return {
      addSiteDialog: false,
      modifySiteDialog: false,
      deleteEmployer: {
        message: '删除后将无法看到该名负责人的所有信息，确认删除？',
        deleteId: '', //  需要删除的数据
        deleteUrl: '',
        listenName: 'listenDeleteSite'
      },
      //  查询工地数据
      queryEmployerData: {
        employer: ''
      },
      //  工地信息
      siteTableData: [],
      //  添加工地信息
      addFormData: {
        construction_id: '', // 工地id
        construction_number: '', // 工地编号
        construction_name: '', // 工地名称
        head_name: '', //  工地负责人姓名
        head_phone: '', //  负责人电话
        construction_address: '', // 工地地址
        construction_longitude: '', // 工地经度
        construction_latitude: '', // 工地纬度
        construction_people: '' //  工地人数
      },
      modifyFormData: {
        construction_id: '', // 工地id
        construction_number: '', // 工地编号
        construction_name: '', // 工地名称
        head_name: '', //  工地负责人姓名
        head_phone: '', //  负责人电话
        construction_address: '', // 工地地址
        construction_longitude: '', // 工地经度
        construction_latitude: '', // 工地纬度
        construction_people: '' //  工地人数
      }
    }
  },
  created () {
    http.get('/construction/list').then(resp => {
      this.siteTableData = resp.data
    })
  },
  methods: {
    //  查找负责人
    queryEmployer () {
      http.post('/construction/getListByID', this.queryEmployerData.employer).then(resp => {
        if (resp.data.length === 0) {
          this.$message.error('没有此工地')
        } else {
          this.siteTableData = resp.data
        }
      })
    },
    //  添加工地负责人
    addEmployer () {
      this.addSiteDialog = true
    },
    sureAddSite (formName) {
      http.post('/construction/addConstruction', this.addFormData).then(resp => {
        if (resp.code === 200) {
          this.refreshTable('true')
          this.$message.success(resp.message)
        } else {
          this.$message.error('添加失败')
        }
        this.$refs[formName].resetFields()
      })
      this.addSiteDialog = false
    },
    cancelAddSite (formName) {
      this.addSiteDialog = false
      this.$refs[formName].resetFields()
    },
    //  修改负责人信息
    modifyEmployerInfo (index, row) {
      this.modifySiteDialog = true
      this.modifyFormData = row
    },
    sureModifySite () {
      http.post('/construction/updateConstruction', this.modifyFormData).then(resp => {
        this.$message.success(resp.message)
      })
      this.modifySiteDialog = false
    },
    cancelModifySite () {
      this.modifySiteDialog = false
      this.refreshTable('true')
    },
    //  删除负责人
    deleteEmployerInfo (index, row) {
      this.deleteEmployer.deleteId = row.construction_id
      this.deleteEmployer.deleteUrl = '/construction/delete'
      this.$refs.deleteEmployer.deleteDialog(this.deleteEmployer)
    },
    clearInput (val) {
      if (val === '') {
        this.refreshTable('true')
      }
    },
    // 刷新表格数据
    refreshTable (val) {
      if (val) {
        http.get('/construction/list').then(resp => {
          this.siteTableData = resp.data
        })
      }
    }
  }
}
</script>

<style scoped lang="less">
.bodyContainer {
  width: 95%;
  height: 500px;
  position: relative;
  left: 2.5%;
  top: 40px;
  .panel {
    width: 100%;
    height: 450px;
    position: absolute;
    top: 30px;
    .centerBox {
      width: 1320px;
      height: 450px;
      position: relative;
      left: 5.5%;
      margin-right: 40px;
      .queryContainer {
        //  输入框样式
        /deep/.el-input__inner{
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
  font-size: 22px;
}
</style>

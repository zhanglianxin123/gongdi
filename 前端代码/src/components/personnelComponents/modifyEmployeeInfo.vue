<template>
  <div>
<!--修改员工信息对话框-->
    <el-dialog title="修改信息" center :visible.sync="modifyDialog" :close-on-click-modal="false">
      <el-form :model="employeeFormData" label-width="80px" ref="employeeForm">
        <el-row>
          <el-col :span="12">
            <el-form-item label="工号" prop="user_id">
              <el-input v-model="employeeFormData.user_id" style="width: 200px"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名" prop="user_name">
              <el-input v-model="employeeFormData.user_name" style="width: 200px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="性别" prop="sex">
              <el-radio-group v-model="employeeFormData.sex">
                <el-radio label="男"></el-radio>
                <el-radio label="女"></el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="身份证号" prop="id_card">
              <el-input v-model="employeeFormData.id_card" style="width: 240px"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="家庭住址" prop="address">
              <el-input v-model="employeeFormData.address" style="width: 240px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="电话号码" prop="phone">
              <el-input v-model="employeeFormData.phone"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="部门" prop="department_name">
              <select-components @listenSelectDepartment="getSelectDepartment" :optionsData="optionsData[0]"></select-components>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="职务" prop="role_name">
             <select-components @listenSelectRole="getSelectRole" :optionsData="optionsData[1]"></select-components>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="所属工地" prop="construction_name">
              <select-components @listenSelectConstruction="getSelectConstruction" :optionsData="optionsData[2]"></select-components>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="sureModifyEmployee">确 定</el-button>
        <el-button @click="cancelModifyEmployee">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import SelectComponents from '@/components/publicComponents/selectComponents'
import http from '@/utils/http'
export default {
  name: 'modifyEmployeeInfo',
  components: { SelectComponents },
  data () {
    return {
      modifyDialog: false, //  是否打开修改信息对话框
      employeeFormData: '', //  员工数据
      getDepartment: '', //  获取选择的部门
      getRole: '', //  获取选择的权限
      getConstruction: '', //  获取所属工地
      getDepartmentID: '', //  获取选择的部门
      getRoleID: '', //  获取选择的权限
      getConstructionId: '', //  获取所属工地
      optionsData: [{
        info: [],
        placeholder: '请选择部门', //  选择器未选中显示的数据
        listenSelectName: 'listenSelectDepartment', //  接收选择器返回的值的函数名
        data: '' //  选择器绑定的数据
      }, {
        info: [],
        placeholder: '请选择职务', //  选择器未选中显示的数据
        listenSelectName: 'listenSelectRole', //  接收选择器返回的值的函数名
        data: '' //  选择器绑定的数据
      }, {
        info: [],
        placeholder: '请选择所属工地', //  选择器未选中显示的数据
        listenSelectName: 'listenSelectConstruction', //  接收选择器返回的值的函数名
        data: '' //  选择器绑定的数据
      }]
    }
  },
  created () {
    //  获取部门信息
    http.get('/department/list').then(resp => {
      resp.data.forEach(item => {
        this.optionsData[0].info.push({ value: item.department_id, label: item.department_name })
      })
    })
    //  获取岗位
    http.get('/role/list').then(resp => {
      resp.data.forEach(item => {
        this.optionsData[1].info.push({ value: item.role_id, label: item.role_name })
      })
    })
    //  获取工地信息
    http.get('/construction/list').then(resp => {
      resp.data.forEach(item => {
        this.optionsData[2].info.push({ value: item.construction_id, label: item.construction_name })
      })
    })
  },
  methods: {
    // 提交修改的信息
    sureModifyEmployee () {
      this.modifyDialog = false
      if (this.getRoleID !== '' && this.getConstructionId !== '' && this.getDepartmentID !== '') {
        //  将返回的部门封装到对象中发送给服务器
        this.employeeFormData.department_name = this.getDepartment
        this.employeeFormData.role_name = this.getRole
        this.employeeFormData.construction_name = this.getConstruction
        this.employeeFormData.department_id = this.getDepartmentID
        this.employeeFormData.construction_id = this.getConstructionId
        this.employeeFormData.role_id = this.getRoleID
        http.post('/user2/update', this.employeeFormData).then(resp => {
          this.$message.success(resp.message)
        })
      } else {
        http.post('/user2/update', this.employeeFormData).then(resp => {
          this.$message.success(resp.message)
        })
      }
    },
    //  取消修改信息
    cancelModifyEmployee () {
      this.modifyDialog = false
    },
    //  父组件中调用此方法打开对话框
    openModifyDialog (row) {
      this.modifyDialog = true
      this.employeeFormData = row
      //  显示当前部门,权限，所属工地
      this.optionsData[0].data = this.employeeFormData.department_id
      this.optionsData[1].data = this.employeeFormData.role_id
      this.optionsData[2].data = this.employeeFormData.construction_id
    },
    //  获取select组件返回的数据
    getSelectDepartment (department) {
      //  获取返回的部门值
      this.getDepartment = department.label
      this.getDepartmentID = department.value
    },
    getSelectRole (role) {
      //  获取返回的权限值
      this.getRole = role.label
      this.getRoleID = role.value
    },
    getSelectConstruction (construction) {
      //  获取返回的工地值
      this.getConstruction = construction.label
      this.getConstructionId = construction.value
    }
  }
}
</script>

<style scoped lang="less">

</style>

<template>
  <div>
    <el-dialog title="添加员工" center :visible.sync="dialogFormVisible" :close-on-click-modal="false">
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
              <select-components @listenDepartment="getDepartment" :optionsData="optionsData[0]"></select-components>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="职务" prop="role_name">
              <select-components @listenRole="getRole" :optionsData="optionsData[1]"></select-components>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="所属工地" prop="construction_name">
              <select-components @listenConstruction="getConstruction" :optionsData="optionsData[2]"></select-components>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="sureAddEmployee('employeeForm')">确 定</el-button>
        <el-button @click="cancelAddEmployee('employeeForm')">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import SelectComponents from '@/components/publicComponents/selectComponents'
import http from '@/utils/http'
export default {
  name: 'addEmployee',
  components: { SelectComponents },
  data () {
    return {
      dialogFormVisible: false,
      department: '',
      department_id: '', //  部门id
      role: '',
      role_id: '', //  职务
      construction: '',
      construction_id: '', //  所在工地
      optionsData: [{
        info: [],
        placeholder: '请选择部门', //  选择器未选中显示的数据
        listenSelectName: 'listenDepartment', //  接收选择器返回的值的函数名
        data: '' //  选择器绑定的数据
      }, {
        info: [],
        placeholder: '请选择职务', //  选择器未选中显示的数据
        listenSelectName: 'listenRole', //  接收选择器返回的值的函数名
        data: '' //  选择器绑定的数据
      }, {
        info: [],
        placeholder: '请选择所属工地', //  选择器未选中显示的数据
        listenSelectName: 'listenConstruction', //  接收选择器返回的值的函数名
        data: '' //  选择器绑定的数据
      }],
      employeeFormData: {
        user_id: '', //  工号
        user_name: '', //  姓名
        sex: '', //  性别
        id_card: '', //  身份证号
        address: '', //  家庭住址
        phone: '', //  电话号码
        department_name: '', //  部门
        department_id: '', //  部门id
        role_name: '', //  职务
        role_id: '', //  职务
        construction_name: '', //  所在工地
        construction_id: '' //  所在工地
      },
      refreshTable: false
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
    //  打开添加对话框
    openDialog () {
      this.dialogFormVisible = true
    },
    //  确认添加员工
    sureAddEmployee (formName) {
      this.dialogFormVisible = false
      this.employeeFormData.construction_name = this.construction
      this.employeeFormData.construction_id = this.construction_id
      this.employeeFormData.role_name = this.role
      this.employeeFormData.role_id = this.role_id
      this.employeeFormData.department_name = this.department
      this.employeeFormData.department_id = this.department_id
      http.post('/user2/addUser', this.employeeFormData).then(resp => {
        this.$message.success(resp.message)
        this.refreshTable = true
        this.$emit('listenAdd', this.refreshTable)
        this.$refs[formName].resetFields()
      })
    },
    //  取消添加员工
    cancelAddEmployee (formName) {
      this.$refs[formName].resetFields()
      this.dialogFormVisible = false
    },
    getDepartment (department) {
      this.department = department.label
      this.department_id = department.value
    },
    getRole (role) {
      this.role = role.label
      this.role_id = role.value
    },
    getConstruction (construction) {
      this.construction = construction.label
      this.construction_id = construction.value
    }
  }
}
</script>

<style scoped lang="less">

</style>

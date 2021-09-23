<template>
  <div>
<!--    删除对话框组件-->
    <el-dialog
      title="确认删除"
      center
      :visible.sync="currentDeleteEmployer"
      width="30%">
      <span>{{message}}</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="sureDelete">确 定</el-button>
        <el-button @click="currentDeleteEmployer = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import http from '@/utils/http'

export default {
  name: 'deleteDialog',
  data () {
    return {
      currentDeleteEmployer: false,
      message: '', //  删除信息
      deleteId: '', //  需要删除的数据的id
      deleteUrl: '', // 需要删除的接口地址
      listenName: '', //  需要删除后刷新表格的函数名
      attribute: 0, // 需要删除的属性
      refreshDelete: false,
      deleteDocument: {
        attribute: 0,
        document_id: ''
      }
    }
  },
  methods: {
    deleteDialog (data) {
      this.currentDeleteEmployer = true
      this.message = data.message
      this.deleteId = data.deleteId
      this.deleteUrl = data.deleteUrl
      this.listenName = data.listenName
      this.attribute = data.attribute
    },
    //  确认删除
    sureDelete () {
      this.currentDeleteEmployer = false
      if (this.attribute === 1 || this.attribute === 2) {
        this.deleteDocument.attribute = this.attribute
        this.deleteDocument.document_id = this.deleteId
        http.post(this.deleteUrl, this.deleteDocument).then(resp => {
          this.$message.success(resp.message)
          this.refreshDelete = true
          this.$emit(this.listenName, this.refreshDelete)
        })
      } else {
        http.post(this.deleteUrl, this.deleteId).then(resp => {
          this.$message.success(resp.message)
          this.refreshDelete = true
          this.$emit(this.listenName, this.refreshDelete)
        })
      }
    }
  }
}
</script>

<style scoped lang="less">

</style>

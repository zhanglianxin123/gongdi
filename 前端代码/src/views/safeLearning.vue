<template>
<!--安全学习-->
  <div class="bodyContainer">
    <el-tabs type="border-card">
      <el-tab-pane label="资料管理">
        <div class="container">
<!--          删除文章对话框-->
          <delete-dialog @listenDeleteArticle="refreshArticleTable" ref="deleteArticle"></delete-dialog>
<!--          删除视频对话框-->
          <delete-dialog @listenDeleteVideo="refreshVideoTable" ref="deleteVideo"></delete-dialog>
<!--          添加对话框-->
          <!--              添加文章对话框-->
          <el-dialog title="添加文章" :visible.sync="addArticleDialog" width="30%" center :close-on-click-modal="false">
            <div style="text-align: center">
            <el-form :model="addArticleData" ref="addArticle" label-width="80px">
              <el-form-item label="文章id" prop="document_id">
                <el-input v-model="addArticleData.document_id" style="width: 240px"></el-input>
              </el-form-item>
              <el-form-item label="文章名" prop="document_name">
                <el-input v-model="addArticleData.document_name" style="width: 240px"></el-input>
              </el-form-item>
              <el-form-item label="文章地址" prop="document_path">
                <el-input v-model="addArticleData.document_path" style="width: 240px"></el-input>
              </el-form-item>
              <el-form-item label="分值" prop="document_score">
                <el-input v-model="addArticleData.document_score" style="width: 240px"></el-input>
              </el-form-item>
            </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="sureAddArticle('addArticle')">确 定</el-button>
              <el-button @click="cancelAddArticle('addArticle')">取 消</el-button>
            </div>
          </el-dialog>
<!--          修改文章对话框-->
          <el-dialog title="修改信息" :visible.sync="modifyArticleDialog" width="30%" center :close-on-click-modal="false">
            <div style="text-align: center">
              <el-form :model="modifyArticleData" label-width="80px">
                <el-form-item label="文章id" prop="document_id">
                  <el-input v-model="modifyArticleData.document_id" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="文章名" prop="document_name">
                  <el-input v-model="modifyArticleData.document_name" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="文章地址" prop="document_path">
                  <el-input v-model="modifyArticleData.document_path" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="分值" prop="document_score">
                  <el-input v-model="modifyArticleData.document_score" style="width: 240px"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="sureModifyArticle">确 定</el-button>
              <el-button @click="cancelModifyArticle">取 消</el-button>
            </div>
          </el-dialog>
<!--          添加视频对话框-->
          <el-dialog title="添加视频" :visible.sync="addVideoDialog" width="30%" center :close-on-click-modal="false">
            <div style="text-align: center">
              <el-form :model="addVideoData" ref="addVideo" label-width="80px">
                <el-form-item label="视频编号" prop="document_id">
                  <el-input v-model="addVideoData.document_id" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="视频名" prop="document_name">
                  <el-input v-model="addVideoData.document_name" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="视频时长" prop="document_name">
                  <el-input v-model="addVideoData.document_time" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="视频地址" prop="document_path">
                  <el-input v-model="addVideoData.document_path" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="分值" prop="document_score">
                  <el-input v-model="addVideoData.document_score" style="width: 240px"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="sureAddVideo('addVideo')">确 定</el-button>
              <el-button @click="cancelAddVideo('addVideo')">取 消</el-button>
            </div>
          </el-dialog>
<!--          修改视频对话框-->
          <el-dialog title="修改信息" :visible.sync="modifyVideoDialog" width="30%" center :close-on-click-modal="false">
            <div style="text-align: center">
              <el-form :model="modifyVideoData" ref="addVideo" label-width="80px">
                <el-form-item label="视频编号" prop="document_id">
                  <el-input v-model="modifyVideoData.document_id" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="视频名" prop="document_name">
                  <el-input v-model="modifyVideoData.document_name" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="视频时长" prop="document_name">
                  <el-input v-model="modifyVideoData.document_time" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="视频地址" prop="document_path">
                  <el-input v-model="modifyVideoData.document_path" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="分值" prop="document_score">
                  <el-input v-model="modifyVideoData.document_score" style="width: 240px"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="sureModifyVideo">确 定</el-button>
              <el-button @click="cancelModifyVideo">取 消</el-button>
            </div>
          </el-dialog>
<!--          修改考试地址对话框-->
          <el-dialog title="修改信息" :visible.sync="modifyExamDialog" width="30%" center :close-on-click-modal="false">
            <div style="text-align: center">
              <el-form :model="modifyExamData" ref="addVideo" label-width="80px">
                <el-form-item label="试卷编号" prop="document_id">
                  <el-input v-model="modifyExamData.document_id" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="试卷名" prop="document_name">
                  <el-input v-model="modifyExamData.document_name" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="试卷地址" prop="document_path">
                  <el-input v-model="modifyExamData.document_path" style="width: 240px"></el-input>
                </el-form-item>
                <el-form-item label="分值" prop="document_score">
                  <el-input v-model="modifyExamData.document_score" style="width: 240px"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="sureModifyExam">确 定</el-button>
              <el-button @click="cancelModifyExam">取 消</el-button>
            </div>
          </el-dialog>
          <div class="menuVerticalContainer">
            <el-tabs tab-position="left" style="height: 400px">
              <el-tab-pane label="文章管理">
                <div class="tableContainer">
                  <div class="queryContainer">
                    <el-form :inline="true" :model="queryArticleData" class="demo-form-inline">
                      <el-form-item>
                        <el-input @input="clearInputArticle" v-model="queryArticleData.document_id" placeholder="请输入文章编号"></el-input>
                      </el-form-item>
                      <el-form-item>
                        <el-button type="primary" @click="queryArticle">查询</el-button>
                      </el-form-item>
                      <el-form-item>
                        <el-button type="primary" @click="addArticle">添加</el-button>
                      </el-form-item>
                    </el-form>
                  </div>
                  <el-table
                    :data="articleData"
                    empty-text="暂无文章"
                    :header-cell-style="{borderColor: '#30eee9'}"
                    style="width: 800px">
                    <el-table-column
                      label="编号"
                      prop="document_id"
                      align="center"
                      width="100">
                    </el-table-column>
                    <el-table-column
                      label="文章名"
                      prop="document_name"
                      align="center"
                      width="200">
                    </el-table-column>
                    <el-table-column
                      label="文章地址"
                      prop="document_path"
                      align="center"
                      width="200">
                    </el-table-column>
                    <el-table-column
                      label="分值"
                      prop="document_score"
                      align="center"
                      width="100">
                    </el-table-column>
                    <el-table-column align="center" width="200" label="操作">
                      <template slot-scope="scope">
                        <el-button
                          size="mini"
                          type="text"
                          style="color: #686de0"
                          @click="editArticle(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                          size="mini"
                          type="text"
                          style="color: #f9ca24"
                          @click="deleteArticle(scope.$index, scope.row)">删除</el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                </div>
                <div class="pagination">
                  <el-pagination
                    background
                    @current-change="currentPageArticle"
                    :page-size="5"
                    :hide-on-single-page="isHide"
                    layout="prev, pager, next"
                    :total="articleNumber">
                  </el-pagination>
                </div>
              </el-tab-pane>
              <el-tab-pane label="视频管理">
                <div class="tableContainer">
                  <div class="queryContainer">
                    <el-form :inline="true" :model="queryVideoData" class="demo-form-inline">
                      <el-form-item>
                        <el-input @input="clearInputVideo" v-model="queryVideoData.document_id" placeholder="输入视频编号"></el-input>
                      </el-form-item>
                      <el-form-item>
                        <el-button type="primary" @click="queryVideo">查询</el-button>
                      </el-form-item>
                      <el-form-item>
                        <el-button type="primary" @click="addVideo">添加</el-button>
                      </el-form-item>
                    </el-form>
                  </div>
                  <el-table
                    :data="videoData"
                    empty-text="暂无视频"
                    :header-cell-style="{borderColor: '#30eee9'}"
                    style="width: 900px">
                    <el-table-column
                      label="编号"
                      prop="document_id"
                      align="center"
                      width="60">
                    </el-table-column>
                    <el-table-column
                      label="视频名"
                      prop="document_name"
                      align="center"
                      width="180">
                    </el-table-column>
                    <el-table-column
                      label="视频时长"
                      prop="document_time"
                      align="center"
                      width="180">
                    </el-table-column>
                    <el-table-column
                      label="视频地址"
                      prop="document_path"
                      align="center"
                      width="200">
                    </el-table-column>
                    <el-table-column
                      label="分值"
                      prop="document_score"
                      align="center"
                      width="100">
                    </el-table-column>
                    <el-table-column align="center" width="180" label="操作">
                      <template slot-scope="scope">
                        <el-button
                          size="mini"
                          type="text"
                          style="color: #686de0"
                          @click="editVideo(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                          size="mini"
                          type="text"
                          style="color: #f9ca24"
                          @click="deleteVideo(scope.$index, scope.row)">删除</el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                </div>
                <div class="pagination">
                  <el-pagination
                    background
                    @current-change="currentPageVideo"
                    :hide-on-single-page="isHide"
                    layout="prev, pager, next"
                    :total="videoNumber">
                  </el-pagination>
                </div>
              </el-tab-pane>
              <el-tab-pane label="考试管理">
                <div class="tableContainer">
                  <el-table
                    empty-text="暂无考试"
                    :data="examTableData"
                    :header-cell-style="{borderColor: '#30eee9'}"
                    style="width: 780px">
                    <el-table-column
                      prop="document_id"
                      width="80"
                      align="center"
                      label="编号">
                    </el-table-column>
                    <el-table-column
                      prop="document_name"
                      width="200"
                      align="center"
                      label="考试名">
                    </el-table-column>
                  <el-table-column
                    prop="document_path"
                    width="200"
                    align="center"
                    label="试卷地址">
                  </el-table-column>
                    <el-table-column
                      prop="document_score"
                      width="100"
                      align="center"
                      label="分值">
                    </el-table-column>
                  <el-table-column align="center" width="200" label="操作">
                    <template slot-scope="scope">
                      <el-button
                        size="mini"
                        type="text"
                        style="color: #686de0"
                        @click="editExam(scope.$index, scope.row)">编辑</el-button>
                    </template>
                  </el-table-column>
                </el-table>
                </div>
              </el-tab-pane>
            </el-tabs>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="积分管理" style="height: 430px">
<!--        查看学习记录对话框-->
        <el-dialog title="学习记录" center :visible.sync="scoreDialog" :close-on-click-modal="false">
          <el-table :data="learningRecordData" empty-text="暂无学习记录">
            <el-table-column align="center" property="attribute_name" label="类型" width="100"></el-table-column>
            <el-table-column align="center" property="document_name" label="文档名" width="200"></el-table-column>
            <el-table-column align="center" property="document_score" label="获得分数"></el-table-column>
          </el-table>
        </el-dialog>
        <div class="tableContainer">
          <div class="queryContainer">
            <el-form :inline="true" :model="queryUserData" class="demo-form-inline">
              <el-form-item>
                <el-input @input="clearInput" v-model="queryUserData.user_id" placeholder="请输入工号"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="queryUserScore">查询</el-button>
              </el-form-item>
            </el-form>
          </div>
          <el-table
            :data="scoreData"
            empty-text="暂无学习人员记录"
            border
            :header-cell-style="{borderColor: '#30eee9'}"
            style="width: 1260px">
            <el-table-column
              label="工号"
              prop="user_id"
              align="center"
              width="180">
            </el-table-column>
            <el-table-column
              label="姓名"
              prop="user_name"
              align="center"
              width="180">
            </el-table-column>
            <el-table-column
              label="所属工地"
              prop="construction_name"
              align="center"
              width="180">
            </el-table-column>
            <el-table-column
              label="部门"
              prop="department_name"
              align="center"
              width="180">
            </el-table-column>
            <el-table-column
              label="联系电话"
              prop="phone"
              align="center"
              width="180">
            </el-table-column>
            <el-table-column
              label="积分"
              prop="score"
              align="center"
              width="180">
            </el-table-column>
            <el-table-column label="操作" align="center">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  style="color: #686de0"
                  @click="lookLearningRecord(scope.$index, scope.row)">学习记录</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <div class="pagination">
          <el-pagination
            background
            @current-change="currentPage"
            layout="prev, pager, next"
            :page-size="5"
            :hide-on-single-page="isHide"
            :total="personNumber">
          </el-pagination>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import DeleteDialog from '@/components/publicComponents/deleteDialog'
import http from '@/utils/http'
export default {
  name: 'safeLearning',
  components: { DeleteDialog },
  data () {
    return {
      personNumber: 0, //  总人数
      isHide: false, //  是否隐藏
      scoreDialog: false,
      addArticleDialog: false,
      modifyArticleDialog: false,
      addVideoDialog: false,
      modifyVideoDialog: false,
      modifyExamDialog: false,
      articleNumber: 0,
      videoNumber: 0,
      //  删除对话框数据
      deleteInfo: {
        attribute: 0, // 需要删除的属性
        message: '',
        deleteId: '', //  需要删除的数据
        deleteUrl: '',
        listenName: ''
      },
      examTableData: [],
      modifyExamData: {
        attribute: 3,
        document_id: '',
        document_name: '',
        document_path: '',
        document_score: ''
      },
      //  文章数据
      articleData: [],
      //  添加文章数据
      addArticleData: {
        attribute: 1,
        document_id: '',
        document_name: '',
        document_path: '',
        document_score: ''
      },
      modifyArticleData: {},
      //  视频数据
      videoData: [],
      addVideoData: {
        attribute: 2,
        document_id: '',
        document_name: '',
        document_time: '',
        document_path: '',
        document_score: ''
      },
      modifyVideoData: {},
      //  工人积分数据
      scoreData: [],
      //  学习记录数据
      learningRecordData: [],
      //  查询文章数据
      queryArticleData: {
        attribute: 1, //  属性名
        document_id: '' //  文档id
      },
      //  查询视频数据
      queryVideoData: {
        attribute: 2, //  属性名
        document_id: '' //  文档id
      },
      //  查询工人积分数据
      queryUserData: {
        user_id: ''
      },
      //  积分分页
      test: {
        current: 1,
        size: 5
      },
      //  文章分页
      documentData: {
        attribute: 1,
        current: 1,
        size: 4
      }
    }
  },
  created () {
    //  渲染出所有工人获得积分
    http.post('/webScore/getList', this.test).then(resp => {
      http.get('/user2/getNumber').then(resp => {
        this.personNumber = resp.data
        //  如果人数不多于5人，则不显示分页器
        if (resp.data <= 5) {
          this.isHide = true
        }
      })
      this.scoreData = resp.data
    })
    //  查询文章数据并渲染
    http.post('/webDocument/getList', this.documentData).then(resp => {
      this.articleData = resp.data
    })
    http.post('/webDocument/getList', { attribute: 2, current: 1, size: 4 }).then(resp => {
      this.videoData = resp.data
    })
    http.post('/webDocument/getList', { attribute: 3, current: 1, size: 4 }).then(resp => {
      this.examTableData = resp.data
    })
    http.post('/webDocument/getSizeByAttribute', 1).then(resp => {
      this.articleNumber = resp.data
      if (resp.data <= 4) {
        this.isHide = true
      }
    })
    http.post('/webDocument/getSizeByAttribute', 2).then(resp => {
      this.videoNumber = resp.data
      if (resp.data <= 4) {
        this.isHide = true
      }
    })
  },
  methods: {
    //  添加文章
    addArticle () {
      this.addArticleDialog = true
    },
    sureAddArticle (formName) {
      this.addArticleDialog = false
      http.post('/webDocument/insert', this.addArticleData).then(resp => {
        this.$message.success(resp.message)
        this.$refs[formName].resetFields()
        http.post('/webDocument/getList', this.documentData).then(resp => {
          this.articleData = resp.data
        })
      })
    },
    cancelAddArticle (formName) {
      this.addArticleDialog = false
      this.$refs[formName].resetFields()
    },
    //  删除文章
    deleteArticle (index, row) {
      this.deleteInfo.message = '删除后工人将无法看到该文章，确认删除？'
      this.deleteInfo.deleteUrl = '/webDocument/delete'
      this.deleteInfo.deleteId = row.document_id
      this.deleteInfo.attribute = row.attribute
      this.deleteInfo.listenName = 'listenDeleteArticle'
      this.$refs.deleteArticle.deleteDialog(this.deleteInfo)
    },
    //  查询文章
    queryArticle () {
      http.post('/webDocument/getListById', this.queryArticleData).then(resp => {
        if (resp.data.length === 0) {
          this.$message.error('没有此文章，请重新输入')
        } else {
          this.articleData = resp.data
        }
      })
    },
    //  修改文章信息
    editArticle (index, row) {
      this.modifyArticleData = row
      this.modifyArticleDialog = true
    },
    //  确认修改
    sureModifyArticle () {
      http.post('/webDocument/update', this.modifyArticleData).then(resp => {
        this.$message.success(resp.message)
      })
      this.modifyArticleDialog = false
    },
    //  取消修改
    cancelModifyArticle () {
      this.modifyArticleDialog = false
      this.refreshArticleTable('true')
    },
    //  查询视频
    queryVideo () {
      http.post('/webDocument/getListById', this.queryVideoData).then(resp => {
        if (resp.data.length === 0) {
          this.$message.error('没有此视频，请重新输入')
        } else {
          this.videoData = resp.data
        }
      })
    },
    //  添加视频
    addVideo () {
      this.addVideoDialog = true
    },
    sureAddVideo (formName) {
      this.addVideoDialog = false
      http.post('/webDocument/insert', this.addVideoData).then(resp => {
        this.$message.success(resp.message)
        this.$refs[formName].resetFields()
        http.post('/webDocument/getList', { attribute: 2, current: 1, size: 4 }).then(resp => {
          this.videoData = resp.data
        })
      })
    },
    cancelAddVideo (formName) {
      this.addVideoDialog = false
      this.$refs[formName].resetFields()
    },
    //  修改视频信息
    editVideo (index, row) {
      this.modifyVideoData = row
      this.modifyVideoDialog = true
    },
    sureModifyVideo () {
      http.post('/webDocument/update', this.modifyVideoData).then(resp => {
        this.$message.success(resp.message)
      })
      this.modifyVideoDialog = false
    },
    cancelModifyVideo () {
      this.modifyVideoDialog = false
      this.refreshVideoTable('true')
    },
    //  删除视频
    deleteVideo (index, row) {
      this.deleteInfo.message = '删除后工人将无法看到该视频，确认删除？'
      this.deleteInfo.deleteUrl = '/webDocument/delete'
      this.deleteInfo.deleteId = row.document_id
      this.deleteInfo.attribute = 2
      this.deleteInfo.listenName = 'listenDeleteVideo'
      this.$refs.deleteVideo.deleteDialog(this.deleteInfo)
    },
    //  查询工人积分
    queryUserScore () {
      http.post('/webScore/getListById', this.queryUserData.user_id).then(resp => {
        if (resp.data.length === 0) {
          this.$message.error('没有此人，请重新输入')
        } else {
          this.scoreData = resp.data
        }
      })
    },
    //  查看工人学习记录
    lookLearningRecord (index, row) {
      http.post('/webScore/getLeanList', row.user_id).then(resp => {
        this.learningRecordData = resp.data
      })
      this.scoreDialog = true
    },
    //  当输入框清空时，重新渲染数据
    clearInput (val) {
      if (val === '') {
        this.refreshScoreTable('true')
      }
    },
    clearInputArticle (val) {
      if (val === '') {
        this.refreshArticleTable('true')
      }
    },
    clearInputVideo (val) {
      if (val === '') {
        this.refreshVideoTable('true')
      }
    },
    //  重新渲染积分表格
    refreshScoreTable (val) {
      if (val) {
        http.post('/webScore/getList', this.test).then(resp => {
          this.scoreData = resp.data
        })
      }
    },
    //  重新渲染文章表格
    refreshArticleTable (val) {
      if (val) {
        http.post('/webDocument/getList', this.documentData).then(resp => {
          this.articleData = resp.data
        })
      }
    },
    //  重新渲染视频表格
    refreshVideoTable (val) {
      if (val) {
        this.documentData.attribute = 2
        http.post('/webDocument/getList', this.documentData).then(resp => {
          this.videoData = resp.data
        })
      }
    },
    //  修改考试路径
    editExam (index, row) {
      this.modifyExamData = row
      this.modifyExamDialog = true
    },
    sureModifyExam () {
      this.modifyExamDialog = false
      http.post('/webDocument/update', this.modifyExamData).then(resp => {
        this.$message.success(resp.message)
      })
    },
    cancelModifyExam () {
      this.modifyExamDialog = false
      http.post('/webDocument/getList', { attribute: 3, current: 1, size: 4 }).then(resp => {
        this.examTableData = resp.data
      })
    },
    currentPage (val) {
      this.test.current = val
      http.post('/webScore/getList', this.test).then(resp => {
        this.scoreData = resp.data
      })
    },
    currentPageArticle (val) {
      this.documentData.current = val
      http.post('/webDocument/getList', this.documentData).then(resp => {
        this.articleData = resp.data
      })
    },
    currentPageVideo (val) {
      this.documentData.current = val
      this.documentData.attribute = 2
      http.post('/webDocument/getList', this.documentData).then(resp => {
        this.videoData = resp.data
      })
    }
  }
}
</script>

<style scoped lang="less">
.bodyContainer {
  width: 95%;
  height: 500px;
  position: absolute;
  left: 2.5%;
  margin-top: 40px;
}
.container {
  width: 100%;
  margin-top: 10px;
  height: 420px;
  .menuVerticalContainer {
    width: 100%;
    margin-right: 40px;
    /deep/.el-tabs__item.is-active {
      color: #30eee9;
    }
    /deep/.el-tabs__item {
      color: #706fd3;
    }
    /deep/.el-tabs__active-bar {
      background-color: #30eee9;
    }
    /deep/.el-tabs__nav-wrap::after {
      background-color: #04193f;
    }
  }
}
.tableContainer {
  text-align: center;
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
  .el-form-item {
    margin-bottom: 0;
    margin-right: 0;
    .el-button {
      margin-left: 30px;
    }
  }
  .el-table {
    position: absolute;
    margin-top: 15px;
    left: 50%;
    transform: translateX(-50%);
  }
}
/deep/.el-tabs--left .el-tabs__header.is-left{
  margin-right: 40px;
}
#pane-0 {
  .el-tab-pane {
    height: 400px;
  }
}
.pagination {
  width: 30%;
  position: absolute;
  left: 50%;
  bottom: 10px;
  text-align: center;
  transform: translateX(-50%);
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
//  分页器样式
/deep/.pagination button,
/deep/.pagination .el-pager li{
  background-color: transparent !important;
  color: #B4C2DC !important;
  border: 1px solid #0672C4;
}
/deep/.pagination .el-pagination.is-background .el-pager li:not(.disabled).active {
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

// pages/sturegister/sturegister.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
 
  },
  formSubmit: function (e) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/lab/WxRegister/student',
      data: {
        stu_id: e.detail.value.stu_id,
        stu_name: e.detail.value.stu_name,
        stu_password: e.detail.value.stu_password
      },
      success: function (res) {
        console.log(res.data);
        if (res.data.message == "YES"){
          console.log("注册成功");
          wx.switchTab({
            url: '/pages/stulogin/stulogin',
          })
        }else{
          console.log("注册失败");
          that.setData({error:"注册失败(没有该学号或已注册)"})
        }
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
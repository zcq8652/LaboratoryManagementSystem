// pages/changePassword/changePassword.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  formSubmit: function (e) {
    var that = this;
    if (e.detail.value.o_password == that.data.u_password && e.detail.value.n_password == e.detail.value.r_password){
      wx.request({
        url: 'http://localhost:8080/lab/WxUser/Password',
        data: {
          u_Id: that.data.u_Id,
          u_position: that.data.u_position,
          n_password: e.detail.value.n_password
        },
        success: function (res) {
          console.log("成功");
          wx.reLaunch({
            url: '/pages/stulogin/stulogin'
          })
        }
      })
    } else if (e.detail.value.o_password != that.data.u_password){
      that.setData({ error: "原密码输入错误" });
    }else{
      that.setData({ error: "新密码两次输入不一致" });
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'uData',
      success: function(res) {
        console.log(res.data);
        that.setData({
          u_Id: res.data.user.u_Id,
          u_password: res.data.user.u_password,
          u_position: res.data.user.u_position
        })
      }
    })
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
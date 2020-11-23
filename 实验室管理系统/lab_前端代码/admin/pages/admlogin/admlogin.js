// pages/admlogin/admlogin.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  formSubmit: function(e){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/lab/WxLogin/admin',
      data: {
        adm_name: e.detail.value.adm_name,
        adm_password: e.detail.value.adm_password
      },
      success: function (res) {
        if (res.data.message == "YES") {
          console.log("登录成功");
          console.log(res.data);
          //缓存数据
          wx.setStorage({
            key: 'uData',
            data: res.data,
            success: function () {
              wx.navigateTo({
                url: '/pages/admin/admin',
              })
            }
          })
        } else {
          console.log("登录失败");
          that.setData({ error: "登录失败" });
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
// pages/admLocation/admLocation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  deleteNotice: function (e) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/lab/WxAttendance/delete',
      data: {
        at_Id: e.currentTarget.dataset.atid
      },
      success: function (res) {
        that.setData({ attendances: res.data.attendances });
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'uData',
      success: function (res) {
        console.log(res.data);
        that.setData({
          u_rank: res.data.user.u_rank
        });
      }
    })
    wx.request({
      url: 'http://localhost:8080/lab/WxAttendance/select',
      success: function (res) {
        console.log(res.data);
        that.setData({ attendances: res.data.attendances });
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
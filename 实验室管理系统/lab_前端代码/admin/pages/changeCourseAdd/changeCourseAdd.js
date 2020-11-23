// pages/changeCourseAdd/changeCourseAdd.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  formSubmit: function (e) {
    wx.showLoading({
      title: '提交中',
    })
    var that = this;
    wx.request({
      url: 'http://localhost:8080/lab/WxTeacherAdjust/add',
      data: {
        t_Id: e.detail.value.t_Id,
        t_name: e.detail.value.t_name,
        ta_content: e.detail.value.ta_content
      },
      success: function (res) {
        wx.hideLoading();
        wx.navigateBack({
          delta: 1
        })
      },
      fail: function () {
        wx.hideLoading();
        wx.showToast({
          icon: 'none',
          title: '提交失败',
        })
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
          u_name: res.data.user.u_name,
          u_Id: res.data.user.u_Id
        });
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
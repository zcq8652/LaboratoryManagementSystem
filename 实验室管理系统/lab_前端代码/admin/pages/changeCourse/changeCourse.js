// pages/changeCourse/changeCourse.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  queryItemClick: function (e) {
    var that = this;
    wx.navigateTo({
      url: '/pages/changeCourseIndex/changeCourseIndex',
      events: {
        // 为指定事件添加一个监听器，获取被打开页面传送到当前页面的数据

      },
      success: function (res) {
        // 通过eventChannel向被打开页面传送数据
        res.eventChannel.emit('acceptDataFromOpenerPage', { data: e.currentTarget.dataset.text })
      }
    })
  },
  deleteRequest: function (e) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/lab/WxTeacherAdjust/delete',
      data: {
        u_Id: that.data.u_Id,
        ta_Id: e.currentTarget.dataset.taid
      },
      success: function (res) {
        that.setData({ tas: res.data.tas });
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
          that.setData({ u_Id: res.data.user.u_Id });
          wx.request({
            url: 'http://localhost:8080/lab/WxTeacherAdjust/select',
            data: {
              u_Id: res.data.user.u_Id
            },
            success: function (res) {
              console.log(res.data);
              that.setData({ tas: res.data.tas });
            }
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
    var that = this;
    wx.getStorage({
      key: 'uData',
      success: function (res) {
        console.log(res.data);
        that.setData({ u_Id: res.data.user.u_Id });
        wx.request({
          url: 'http://localhost:8080/lab/WxTeacherAdjust/select',
          data: {
            u_Id: res.data.user.u_Id
          },
          success: function (res) {
            console.log(res.data);
            that.setData({ tas: res.data.tas });
          },
          complete: function (res) {
            wx.stopPullDownRefresh();
          }
        });
      }
    })
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
// pages/admChangeCourse/admChangeCourse.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  //高级管理员点击记录，进入详情页
  queryItemClick: function (e) {
    var that = this;
    wx.navigateTo({
      url: '/pages/admChangeCourseIndex/admChangeCourseIndex',
      events: {
        // 为指定事件添加一个监听器，获取被打开页面传送到当前页面的数据

      },
      success: function (res) {
        // 通过eventChannel向被打开页面传送数据
        res.eventChannel.emit('acceptDataFromOpenerPage', { 
          data: e.currentTarget.dataset.text,
          labs: that.data.labs 
        })
      }
    })
  },
  //普通管理员点击记录，进入详情页
  adminQueryItemClick: function(e){
    var that = this;
    wx.navigateTo({
      url: '/pages/admChangeCourseIndex/admChangeCourseIndex',
      events: {
        // 为指定事件添加一个监听器，获取被打开页面传送到当前页面的数据

      },
      success: function (res) {
        // 通过eventChannel向被打开页面传送数据
        res.eventChannel.emit('acceptDataFromOpenerPage', {
          data: e.currentTarget.dataset.text
        })
      }
    })
    if(e.currentTarget.dataset.text.aa_state == "1"){
      wx.request({
        url: 'http://localhost:8080/lab/WxAdjust/updateNew',
        data:{
          aa_Id: e.currentTarget.dataset.text.aa_Id,
          u_Id: that.data.u_Id
        },
        success: function(res){
          that.setData({
            adminAdjusts: res.data.adminAdjusts
          })
        }
      })
    }
  },
  deleteRequest: function (e) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/lab/WxAdjust/delete',
      data: {
        ad_Id: e.currentTarget.dataset.adid,
        u_rank: that.data.u_rank
      },
      success: function (res) {
        that.setData({ 
          adjusts: res.data.adjusts,
          adminAdjusts: res.data.adminAdjusts
         });
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
          u_Id: res.data.user.u_Id,
          u_rank: res.data.user.u_rank
        });
        wx.request({
          url: 'http://localhost:8080/lab/WxAdjust/selete',
          data: {
            u_Id: res.data.user.u_Id,
            u_rank: res.data.user.u_rank
          },
          success: function (res) {
            console.log(res.data);
            that.setData({ 
              adjusts: res.data.adjusts,
              adminAdjusts: res.data.adminAdjusts,
              labs: res.data.labs
            });
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
    wx.request({
      url: 'http://localhost:8080/lab/WxAdjust/selete',
      data: {
        u_Id: that.data.u_Id,
        u_rank: that.data.u_rank
      },
      success: function (res) {
        console.log(res.data);
        that.setData({ 
          adjusts: res.data.adjusts,
          adminAdjusts: res.data.adminAdjusts,
          labs: res.data.labs
        });
      },
      complete: function (res) {
        wx.stopPullDownRefresh();
      }
    });
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
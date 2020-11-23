Page({

  /**
   * 页面的初始数据
   */
  data: {
    sin: "签到",
    sout: "签退",
    markers: [{
      id: 0,
      latitude: 37.425,
      longitude: 112.5836,
      width: 30,
      height: 30,
      label:{
        anchorX: 8,
        anchorY: -25,
        content:"实验中心",
        color: '#1296db'
      }
    }]
  },
  regionchange(e) {
    console.log(e.type)
  },
  markertap(e) {
    console.log(e.markerId)
  },
  signInSubmit: function(e){
    wx.showLoading({
      title: '签到中',
    })
    var that = this;
    if (that.data.latitude > 38.5012 && that.data.latitude < 38.5013 && that.data.longitude > 112.766 && that.data.longitude < 112.767){
      wx.request({
        url: 'http://localhost:8080/lab/WxAttendance/add',
        data: {
          t_name: that.data.u_name,
          t_Id: that.data.u_Id,
          at_at: e.currentTarget.dataset.sin
        },
        success: function () {
          wx.hideLoading();
          wx.showToast({
            title: '签到成功',
          })
        },
        fail: function () {
          wx.hideLoading();
          wx.showToast({
            icon: 'none',
            title: '签到失败，系统忙碌',
          })
        }
      });
    }else{
      wx.hideLoading();
      wx.showToast({
        icon: 'none',
        title: '签到失败，您未在可签到范围内',
      })
    }
  },
  signOutSubmit: function(e){
    wx.showLoading({
      title: '签退中',
    })
    var that = this;
    if (that.data.latitude > 38.5012 && that.data.latitude < 38.5013 && that.data.longitude > 112.766 && that.data.longitude < 112.767) {
      wx.request({
        url: 'http://localhost:8080/lab/WxAttendance/add',
        data: {
          t_name: that.data.u_name,
          t_Id: that.data.u_Id,
          at_at: e.currentTarget.dataset.sout
        },
        success: function () {
          wx.hideLoading();
          wx.showToast({
            title: '签退成功',
          })
        },
        fail: function () {
          wx.hideLoading();
          wx.showToast({
            icon: 'none',
            title: '签退失败，系统忙碌',
          })
        }
      });
    } else {
      wx.hideLoading();
      wx.showToast({
        icon: 'none',
        title: '签退失败，您未在可签退范围内',
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    let sInfo = wx.getSystemInfoSync();
    console.log(sInfo);
    that.setData({
      locationEnabled: sInfo.locationEnabled,//地理位置的系统开关
      locationAuthorized: sInfo.locationAuthorized//允许微信使用定位的开关
    })
    console.log(sInfo.locationEnabled);
    console.log(sInfo.locationAuthorized);
    //if (that.data.locationEnabled == true){
      //if (that.data.locationAuthorized == true){
        wx.getLocation({
          type: 'wgs84',
          success(res) {
            console.log(res.latitude);
            console.log(res.longitude);
            that.setData({
              latitude: res.latitude,
              longitude: res.longitude
            })
          }
        });
      //}else{
        //用户已授权，但是获取地理位置失败，提示用户去微信设置中打开定位
        //wx.showModal({
          //title: '',
          //content: '请在微信权限中打开定位服务，然后重新进入该页面',
          //confirmText: '确定',
          //success: function (res) {

          //}
        //})
      //}
    //}else{
      //用户已授权，但是获取地理位置失败，提示用户去系统设置中打开定位
      //wx.showModal({
        //title: '',
        //content: '请在系统设置中打开定位服务，然后重新进入该页面',
        //confirmText: '确定',
        //success: function (res) {
          
       // }
      //})
    //}
  
    wx.getStorage({
      key: 'uData',
      success: function (res) {
        console.log(res.data);
        that.setData({
          u_name: res.data.user.u_name,
          u_Id: res.data.user.u_Id
        });
      }
    });
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
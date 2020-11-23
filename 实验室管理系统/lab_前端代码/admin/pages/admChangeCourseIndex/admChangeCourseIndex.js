// pages/admChangeCourseIndex//admChangeCourseIndex.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sectionShow: true,
    items: [
      { name: 'agree', value: '同意' },
      { name: 'disagree', value: '不同意', checked: 'true' }
    ],
    radioChoice: "不同意",
    isLabName: 0
  },
  bindPickerChange: function(e){
    var that = this;
    that.setData({
      isLabName: e.detail.value
    })
  },
  //主任的同意不同意单选
  radioChange: function(e){
    var that = this;
    if (e.detail.value == "同意"){
      that.setData({
        sectionShow: false,
        radioChoice: "同意"
      })
    }else{
      that.setData({
        sectionShow: true,
        radioChoice: "不同意"
      })
    }
  },
  zhuren_sure: function(){
    var that = this;
    wx.showLoading({
      title: '提交中',
    })
    if (that.data.radioChoice == "同意") {
    wx.request({
      url: 'http://localhost:8080/lab/WxAdjust/update',
      data: {
        result: 1,
        ad_Id: that.data.adjusts.ad_Id,
        u_rank: that.data.u_rank,
        a_Id: that.data.labs[that.data.isLabName].a_Id
      },
      success: function () {
        wx.hideLoading();
        wx.showToast({
          title: '提交成功',
        })
          that.setData({
            sign: '0'
          });
      }
    })
    }else{
      wx.request({
        url: 'http://localhost:8080/lab/WxAdjust/update',
        data: {
          result: 0,
          ad_Id: that.data.adjusts.ad_Id,
          u_rank: that.data.u_rank
        },
        success: function () {
          wx.hideLoading();
          wx.showToast({
            title: '提交成功',
          })
          that.setData({
            sign: '3'
          });
        }
      })
    }
  },
  //院长点击同意按钮
  agree: function(){
    var that = this;
    wx.showLoading({
      title: '提交中',
    })
    wx.request({
      url: 'http://localhost:8080/lab/WxAdjust/update',
      data: {
        result: 1,
        ad_Id: that.data.adjusts.ad_Id,
        u_rank: that.data.u_rank
      },
      success: function(){
        wx.hideLoading();
        wx.showToast({
          title: '提交成功',
        })
        that.setData({
          sign: '1'
        }); 
      }
    })
  },
  //院长点击不同意按钮
  notAgree: function(){
    var that = this;
    wx.showLoading({
      title: '提交中',
    })
    wx.request({
      url: 'http://localhost:8080/lab/WxAdjust/update',
      data: {
        result: 0,
        ad_Id: that.data.adjusts.ad_Id,
        u_rank: that.data.u_rank
      },
      success: function(){
        wx.hideLoading();
        wx.showToast({
          title: '提交成功',
        })
        that.setData({
          sign: '3'
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
          u_rank: res.data.user.u_rank
        });
      }
    });
    const eventChannel = this.getOpenerEventChannel();
    // 监听acceptDataFromOpenerPage事件，获取上一页面通过eventChannel传送到当前页面的数据
    eventChannel.on('acceptDataFromOpenerPage', function (data) {
      that.setData({ 
        adjusts: data.data,
        sign: data.data.ad_state,
        labs: data.labs
      });
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
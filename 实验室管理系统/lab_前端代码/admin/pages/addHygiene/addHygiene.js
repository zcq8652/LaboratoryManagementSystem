// pages/addHygiene/addHygiene.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    images:[]
  },
  upLoadImg: function () {
    //选择图片
    wx.chooseImage({
      count: 9,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: res => {
        // tempFilePath可以作为img标签的src属性显示图片
        const tempFilePaths = res.tempFilePaths;
        console.log(tempFilePaths);
        this.setData({
          images: this.data.images.concat(tempFilePaths)
        });
      }
    })
  },
  formSubmit: function(e){
    wx.showLoading({
      title: '提交中',
    })
    var that = this;
    let promise1 = new Promise(function (resolve, reject) {
      wx.request({
        url: 'http://localhost:8080/lab/WxHealth/add',
        data: {
          u_name: e.detail.value.u_name,
          u_Id: e.detail.value.u_Id,
          h_content: e.detail.value.h_content
        },
        success: function (res) {
          console.log("请求成功！");
          console.log(res.data.h_Id);
          that.setData({ h_Id: res.data.h_Id });
          resolve(res.data);
        },
        fail: function(res){
          console.log("请求失败！");
          reject(res.data);
        }
      });
    });
    Promise.all([promise1]).then(res => {
      if (that.data.images.length > 0){
        for (var i = 0; i < that.data.images.length; i++) {
          var item = that.data.images[i];
          wx.uploadFile({
            url: 'http://localhost:8080/lab/WxHealth/uploadImg',
            filePath: item,
            name: 'file',
            formData: {
              h_Id: JSON.stringify(that.data.h_Id)
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
          });
        }
      }else{
        wx.hideLoading();
        wx.navigateBack({
          delta: 1
        })
      }
    });
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
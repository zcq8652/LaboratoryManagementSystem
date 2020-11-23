// pages/courseTable/courseTable.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    colorArr: ["#57A460", "#5EBD8B", "#FF9899", "#FE9667", "#986699",
      "#D0A308", "#FA5AA2", "#7898AA", "#C35CFF", "#33BCBA", "#C28F5C",
      "#FF8533", "#6E6E6E", "#428BCA", "#5cb85c", "#FF674F", "#E9967A",
      "#66CDAA", "#00CED1", "#9F79EE", "#CD3333", "#FFC125", "#32CD32",
      "#00BFFF", "#68A2D5", "#FF69B4", "#DB7093", "#CD3278", "#607B8B"]
  },
  btnClick: function(e){
    var that = this;
    wx.request({
      url: 'http://localhost:8080/lab/WxSchedule/select',
      data: {
        l_Id: e.currentTarget.dataset.lid
      },
      success: function(res){
        console.log(res.data);
        that.setData({
          one: res.data.Schedules[0],
          two: res.data.Schedules[1],
          three: res.data.Schedules[2],
          four: res.data.Schedules[3],
          five: res.data.Schedules[4],
          six: res.data.Schedules[5]
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/lab/WxSchedule/select',
      success: function(res){
        console.log(res.data);
        that.setData({
          one: res.data.Schedules[0],
          two: res.data.Schedules[1],
          three: res.data.Schedules[2],
          four: res.data.Schedules[3],
          five: res.data.Schedules[4],
          six: res.data.Schedules[5],
          labs: res.data.labs
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
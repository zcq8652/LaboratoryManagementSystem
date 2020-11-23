Component({
  properties: {
    
  },
  data: {
    sign: true
  },
  methods: {
    hiddenAndShow: function(){
      this.setData({
        sign: !this.data.sign
      })
    }
  },
  lifetimes: {
    ready: function(){
      var that = this;
      wx.getStorage({
        key: 'uData',
        success: function (res) {
          console.log(res.data);
          that.setData({
            u_name: res.data.user.u_name
          });
        }
      })
    }
  }
})
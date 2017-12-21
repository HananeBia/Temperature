var app = new Vue({
  el: '#app',
  data: {
    rooms: [],
    newRoomForm: false,
    newRoom:{}
  },
  methods: {
    getrooms: function () {
      axios.get('http://localhost:8080/api/rooms')
      .then(function (response) {app.rooms=response.data;
      })
      .catch(function (error) {
        console.log(error);
      });
    },


    initNewRoom: function(){
      var maxRoom=0;
      var maxTemperature=0;

      for (var i = 0; i < app.rooms.length; i++) {
        if(app.rooms[i].id>maxRoom){
          maxRoom=app.rooms[i].id;
        }
        if(app.rooms[i].temperature.id>maxTemperature){
          maxTemperature=app.rooms[i].temperature.id;
        }

      }
      var maxRoom1= maxRoom+1;
      this.newRoom.id=maxRoom+1;
      this.newRoom.name='F0'+maxRoom1;
      Vue.set(app.newRoom, 'temperature', {});
      Vue.set(app.newRoom.temperature, 'id', maxTemperature+1);
      Vue.set(app.newRoom.temperature, 'degree', 38);


      this.newRoomForm=true;
    },
    sendNewRoom: function(){
      axios({
        method: 'post',
        url: 'http://localhost:8080/api/rooms/new',
        data: app.newRoom
      })
        .then(function(response) {
          app.rooms.push(app.newRoom);
          app.newRoomForm=false;
      });
    },
    delete_room: function(id){
      if (confirm("Would you really delete the room "+id+" ?")) {
        var j=0;
        for (var i = 0; i < app.rooms.length; i++) {
          if(app.rooms[i].id==id){
            j=i;
          }
        }
        axios.post('http://localhost:8080/api/rooms/'+id+'/delete')
        .then(function (response) {
          app.rooms.splice(j,1);
        })
        .catch(function (error) {
          console.log(error);
        });
      }
    }
  },
  mounted: function (){
    this.getrooms();
  }
})

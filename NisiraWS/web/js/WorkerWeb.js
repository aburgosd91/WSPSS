    /*DEFINICIONES*/
self.addEventListener('message', function(e) {
    importScripts('fabric.js');
    /** DEFINICIONES **/
    var canvas = new fabric.Canvas('c',{
        allowTouchScrolling:true,
        width:window.innerWidth,
        height:window.innerHeight
    });
    canvas.setWidth($(window).width());
    canvas.setHeight($(window).height() - $('#tools').outerHeight());
    var initTools = function(c){
        /* AGREGAR COMPONENTES A CANVAS*/
        for(var cx=1; cx<dimensionX;cx++){
            for(var cy=1; cy<dimensionY;cy++){
                c.add(new fabric['Rect']({ 
                        width: areacelda, 
                        height: areacelda, 
                        top: (cx*areacelda)+0.2, 
                        left: (cy*areacelda)+0.2,
                        fill: '#fff',
                        stroke: 'black',
                        strokeWidth: 1,
                        selectable :false
                    })
                );
            }
        }
    };
    var loadState = function (c){
        var existingState = JSON.parse(localStorage.getItem("existingState"))
        if (existingState && existingState.length > 0)
        {
          skipSave = true;
          c.loadFromJSON(JSON.parse(existingState[existingState.length - 1]),function (){
              skipSave = false;
          });
        }
    };
    console.log(e.data);
    initTools(canvas);
    loadState(canvas);
    self.postMessage(true);
}, false);

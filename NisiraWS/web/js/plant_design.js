/* 
 * Variables Globales
 */
var canvas ;
var sDirectorio =  "../plant/";
var nombrePlanta = "";
var dimensionX = 50;
var dimensionY = 50;
var areacelda=30;
var SCALE_FACTOR = 2;
var oldStates = [];
var skipSave = false;
var MAX_VALUE = 10000;

/* FORMULARIO */
var dialog_insertRack_validar = function (){
    document.getElementById("datos:pisos_input").focus();
};
/* CANVAS GLOBAL*/
var method_zoomMas = function (){
    zoomMas(canvas);
};
var method_zoomMenos = function (){
    zoomMenos(canvas);
};
var method_initTools = function (dimension){
    console.log(dimension);
    areacelda=dimension;
    clearState(canvas);
    initTools(canvas);
};
/* CANVAS LOCAL*/
var object_types = {
  'suelo': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'carrosatelite': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'compactamono': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'compactamulti': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'convencionales': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'dinamica': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'pushback': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }]
};
var zoomMas = function (c){
    c.zoomToPoint(new fabric.Point(0,0), c.getZoom() * 1.1);
    c.scale(c.getZoom() * 1.1,c.getZoom() * 1.1);
};
var zoomMenos = function (c){
    c.zoomToPoint(new fabric.Point(0,0), c.getZoom() / 1.1);
    c.scale(c.getZoom() / 1.1,c.getZoom() / 1.1);
};
var saveState = function (c){
  var existingState = JSON.parse(localStorage.getItem("existingState"));
  if(!existingState)
    existingState = [];
  if(!skipSave && JSON.stringify(c) != existingState[existingState.length - 1]){
    existingState.push(JSON.stringify(c));
    localStorage.setItem("existingState", JSON.stringify(existingState));
    oldStates = [];
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
var undoState = function(c){
  var existingState = JSON.parse(localStorage.getItem("existingState"));
  if (existingState && existingState.length > 0)
    oldStates.push(existingState.pop());
    if (existingState.length > 0){
      skipSave = true;
      c.loadFromJSON(JSON.parse(existingState[existingState.length - 1]),function (){ 
          skipSave = false;
      });
    } 
    else{
      c.clear();
    }
    localStorage.setItem("existingState", JSON.stringify(existingState));
};
var redoState = function (c){
  var existingState = JSON.parse(localStorage.getItem("existingState"));
  if (!existingState)
    existingState = [];
  if(oldStates.length > 0){
    existingState.push(oldStates.pop());
    localStorage.setItem("existingState", JSON.stringify(existingState));
    loadState(c);
  }
};
var clearState = function (c){
  localStorage.removeItem("existingState");
  c.clear();
  oldStates = [];
};
var removeItem = function (c){
  var obj = c.getActiveObject();
  var grp = c.getActiveGroup();
  c.remove(obj);
  grp.forEachObject(function(o){
    c.remove(o);
    c.discardActiveGroup().renderAll();
  });
  saveState(c);
};
var zupItem = function(c){
  var obj = c.getActiveObject();
  obj.bringForward();
};
var zdownItem = function (c){
  var obj = c.getActiveObject();
  obj.sendBackwards();
};
var initTools = function(c){
    /* AGREGAR COMPONENTES A CANVAS*/
//    for(var cx=1; cx<dimensionX;cx++){
//        for(var cy=1; cy<dimensionY;cy++){
//            c.add(new fabric['Rect']({ 
//                    width: areacelda, 
//                    height: areacelda, 
//                    top: (cx*areacelda)+0.2, 
//                    left: (cy*areacelda)+0.2,
//                    fill: '#fff',
//                    stroke: 'black',
//                    strokeWidth: 1,
//                    selectable :false
//                })
//            );
//        }
//    }
};
var loadProperties = function(c){
    var obj = c.getActiveObject();
    if (!obj){
        unloadProperties(c);
        return;
    }
    $('#tools #properties').append("<label for='fill'>Fill</label><input id='fill' type='text' class='colorPicker' value='"+obj.fill+"' />");
    $('#fill').colorpicker().on('changeColor',function(e){
        obj.setFill($(e.currentTarget).val());
        c.renderAll();
    });
    $('#tools #properties').append("<label for='stroke'>Stroke</label><input id='stroke' type='text' class='colorPicker' value='"+obj.stroke+"' />");
    $('#stroke').colorpicker().on('changeColor',function(e){
        obj.setStroke($(e.currentTarget).val());
        c.renderAll();
    });
    $('#tools #properties').append("<label for='strokewidth'>Stroke Width</label><input id='strokewidth' type='number' value='"+obj.strokeWidth+"' />");
    $('#strokewidth').on('change',function(e){
        obj.setStrokeWidth(parseInt($(e.currentTarget).val()));
        c.renderAll();
    });
};
var unloadProperties = function(c){
    saveState(c);
    $('#tools #properties').html("");
};
var mensajito=function messageAlert(){
    alert("messageAlert");
};
/* CANVAS GLOBAL*/
var cambioFondo= function(path){
    nombrePlanta = path;
    
    canvas.setBackgroundImage(sDirectorio+nombrePlanta, canvas.renderAll.bind(canvas), {
        backgroundImageOpacity: 0.5,
        backgroundImageStretch: false,
        width: canvas.width,
        height: canvas.height
    });
//    canvas.setOverlayImage(sDirectorio+nombrePlanta, canvas.renderAll.bind(canvas),{
//        width: canvas.width,
//        height: canvas.height,
//        opacity: 0.98
//    }); 
    initTools(canvas);
};
var componenteRack = function(nfilas,ncolumnas){
        console.log(nfilas);
        console.log(ncolumnas);
        var _url_='../../easywms/TIPO_RACK/';
        var padding = 0;
        fabric.Image.fromURL(_url_+'posicion.png', function(oImg){
            oImg.setWidth(areacelda);
            oImg.setHeight(areacelda);
            var patternSourceCanvas = new fabric.StaticCanvas();
            patternSourceCanvas.add(oImg);
            var pattern = new fabric.Pattern({
              source: function() {
                patternSourceCanvas.setDimensions({
                  width: oImg.getWidth(),
                  height: oImg.getHeight()
                });
                return patternSourceCanvas.getElement();
              },
              repeat: 'repeat'
            });
            canvas.add(new fabric.Rect({
                left: 0,
                top: 50,
                width: oImg.getWidth()* nfilas, 
                height: oImg.getHeight()*ncolumnas ,
                fill: pattern
            }));
    //        canvas.add(oImg);
        });
    };
function trackTransforms(ctx){
      var svg = document.createElementNS("http://www.w3.org/2000/svg",'svg');
      var xform = svg.createSVGMatrix();
      ctx.getTransform = function(){ return xform; };

      var savedTransforms = [];
      var save = ctx.save;
      ctx.save = function(){
          savedTransforms.push(xform.translate(0,0));
          return save.call(ctx);
      };
    
      var restore = ctx.restore;
      ctx.restore = function(){
        xform = savedTransforms.pop();
        return restore.call(ctx);
		      };

      var scale = ctx.scale;
      ctx.scale = function(sx,sy){
        xform = xform.scaleNonUniform(sx,sy);
        return scale.call(ctx,sx,sy);
		      };
    
      var rotate = ctx.rotate;
      ctx.rotate = function(radians){
          xform = xform.rotate(radians*180/Math.PI);
          return rotate.call(ctx,radians);
      };
    
      var translate = ctx.translate;
      ctx.translate = function(dx,dy){
          xform = xform.translate(dx,dy);
          return translate.call(ctx,dx,dy);
      };
    
      var transform = ctx.transform;
      ctx.transform = function(a,b,c,d,e,f){
          var m2 = svg.createSVGMatrix();
          m2.a=a; m2.b=b; m2.c=c; m2.d=d; m2.e=e; m2.f=f;
          xform = xform.multiply(m2);
          return transform.call(ctx,a,b,c,d,e,f);
      };
    
      var setTransform = ctx.setTransform;
      ctx.setTransform = function(a,b,c,d,e,f){
          xform.a = a;
          xform.b = b;
          xform.c = c;
          xform.d = d;
          xform.e = e;
          xform.f = f;
          return setTransform.call(ctx,a,b,c,d,e,f);
      };
    
      var pt  = svg.createSVGPoint();
      ctx.transformedPoint = function(x,y){
          pt.x=x; pt.y=y;
          return pt.matrixTransform(xform.inverse());
      }
	}
$(document).ready(function(){
   // do jQuery
    canvas = new fabric.Canvas('c',{
        allowTouchScrolling:true,
        width:window.innerWidth,
        height:window.innerHeight
    });
//    canvas.setOverlayImage(sDirectorio+nombrePlanta, canvas.renderAll.bind(canvas),{
//        width: canvas.width,
//        height: canvas.height 
//    }); 
    initTools(canvas);
    canvas.setWidth($(window).width());
    canvas.setHeight($(window).height() - $('#tools').outerHeight());
    loadState(canvas);
//    var worker = new Worker('../js/WorkerWeb.js');
//    worker.addEventListener('message', function(e) {
//        console.log(e.data);
//    }, false);
//    worker.postMessage(false); // Send data to our worker.
    $("#clear").click(function(d){
        canvas.clear();
        saveState(canvas);
    });
    $("#clearall").click(function(d){
        clearState(canvas);
    });
    $("#save").click(function(d){
        var download = function(url,name){
            $('<a>').attr({href:url,download:name})[0].click();
        };
        download(canvas.toDataURL(),'floorplan.png');
    });
    $("#undo").click(function(d){
        undoState(canvas);
    });
    $("#redo").click(function(d){
        redoState(canvas);
    });
    $("zoom_mas").click(function(d){
        zoomMas(canvas);
    });
    $("zoom_menos").click(function(d){
        zoomMenos(canvas);
    });
//    $("#zoom_mas").click(function(d){
//        zoomMas(canvas);
//    });
//    $("#zoom_menos").click(function(d){
//        zoomMenos(canvas);
//    });
    
    canvas.on('bject:added',function(d){
        saveState(canvas);
    });
    canvas.on('object:modified',function(d){
        saveState(canvas);
    });
//    canvas.on('object:selected',function(d){
//        loadProperties(canvas);
//    });
    canvas.on('before:selection:cleared',function(d){
        unloadProperties(canvas);
    });
    canvas.on('selection:cleared',function(d){
        unloadProperties(canvas);
    });
    $(document).keydown(function(e){
        if (e.which == 90 && e.ctrlKey && e.shiftKey)
            redoState(canvas);
        else if (e.which == 90 && e.ctrlKey)
            undoState(canvas);
        else if (e.which == 46)
           removeItem(canvas);
        else if (e.which == 33)
           zupItem(canvas);
        else if (e.which == 34)
           zdownItem(canvas);
    });
//    $("#componenteRack").click(function(d){
//        componenteRack(canvas);
//    });
});

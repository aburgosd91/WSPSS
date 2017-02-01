# variables globales
dimensionX =[1..20]
dimensionY =[1..30]
areacelda=20
SCALE_FACTOR = 2
oldStates = []
skipSave = false



object_types = {
  #'Circle': [{ radius: 30, fill: 'black', top: 100, left: 100, fill: 'lightblue', stroke: 'black', strokeWidth: 5 }], 
  #'Line': [[10, 0, 10, 100], { fill: 'black', stroke: 'black', strokeWidth: 10 }], 
  #'Rect': [{ left: 100, top: 100, width: 100, height: 100, fill: 'lightblue', stroke: 'black', strokeWidth: 5, }], 
  #'Triangle': [{fill: 'lightblue', stroke: 'black', strokeWidth: 5}], 
  #'Ellipse': [{top: 100, left: 100, rx: 100, ry: 75, fill: 'lightblue', stroke: 'black', strokeWidth: 5 }], 
  # 'Polyline': [{}], 
  # 'Polygon': [{}], 
  # 'Text': [{}], 
  'suelo': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'carrosatelite': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'compactamono': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'compactamulti': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'convencionales': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'dinamica': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'pushback': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  'suelo': [{ type:'Image',left: 100, top: 100, width: 100, height: 100 }], 
  # 'Path': [{}]
}
zoomMas = (c) ->
  c.zoomToPoint(new fabric.Point(0,0), c.getZoom() * 1.1)
  #c.setHeight c.getHeight() * SCALE_FACTOR
  #c.setWidth c.getWidth() * SCALE_FACTOR
zoomMenos = (c) ->
  c.zoomToPoint(new fabric.Point(0,0), c.getZoom() / 1.1)
  #c.setHeight(c.getHeight() * (1 / SCALE_FACTOR));
  #c.setWidth(c.getWidth() * (1 / SCALE_FACTOR));
saveState = (c) ->
  existingState = JSON.parse(localStorage.getItem("existingState"))
  if !existingState
    existingState = []
  if !skipSave && JSON.stringify(c) != existingState[existingState.length - 1]
    existingState.push JSON.stringify(c)
    localStorage.setItem("existingState", JSON.stringify(existingState))
    oldStates = []

loadState = (c) ->
  existingState = JSON.parse(localStorage.getItem("existingState"))
  if existingState && existingState.length > 0
    skipSave = true
    c.loadFromJSON JSON.parse(existingState[existingState.length - 1]), -> skipSave = false

undoState = (c) ->
  existingState = JSON.parse(localStorage.getItem("existingState"))
  
  if existingState && existingState.length > 0
    oldStates.push existingState.pop()
    if existingState.length > 0
      skipSave = true
      c.loadFromJSON JSON.parse(existingState[existingState.length - 1]), -> skipSave = false
    else
      c.clear()
    localStorage.setItem("existingState", JSON.stringify(existingState))

redoState = (c) ->
  existingState = JSON.parse(localStorage.getItem("existingState"))

  if !existingState
    existingState = []
  if oldStates.length > 0
    existingState.push oldStates.pop()
    localStorage.setItem("existingState", JSON.stringify(existingState))
    loadState(c)

clearState = (c) ->
  localStorage.removeItem("existingState")
  c.clear()
  oldStates = []

removeItem = (c) ->
  obj = c.getActiveObject()
  grp = c.getActiveGroup()
  c.remove obj
  grp.forEachObject (o) ->
    c.remove o
    c.discardActiveGroup().renderAll()
  saveState(c)
  
zupItem = (c) ->
  obj = c.getActiveObject()
  obj.bringForward()
zdownItem = (c) ->
  obj = c.getActiveObject()
  obj.sendBackwards()

initTools = (c) ->
  ###### DIBUJAR MATRIZ PLATAFORMA##########
  for cx in dimensionX
    for cy in dimensionY
      c.add new fabric['Rect']({ width: areacelda, height: areacelda, top: cx*areacelda, left: cy*areacelda ,fill: '#fff',stroke: 'black',strokeWidth: 1,selectable :false})
  #celda = new fabric['Rect']({ width: 50, height: 50, fill: '#77f', top: 150, left: 150 , selectable :false})
  #c.add celda
  ##########################################
  for tn,defo of object_types
    $('#tools #shapes').append "<button class='btn btn-warning' id='#{tn}'>#{tn}</button>"
    $("##{tn}").click [tn, defo], (t) ->
      nobj = new fabric[t.data[1][0].type](t.data[1]...)
      console.log(t.data[0])
      type_img = (t.data[0])
      url_='../../easywms/TIPO_RACK/'
      #console.log((t.data[1][0]).type_img)
      if t.data[1][0].type is 'Image'
        switch type_img
          when 'carrosatelite' then fabric.Image.fromURL(url_+'carrosatelite.png', (oImg)-> c.add oImg)
          when 'compactamono' then fabric.Image.fromURL(url_+'carrosatelite.png', (oImg)-> c.add oImg)
          when 'compactamulti' then fabric.Image.fromURL(url_+'compactamulti.png', (oImg)-> c.add oImg)
          when 'convencionales' then fabric.Image.fromURL(url_+'convencionales.png', (oImg)-> c.add oImg)
          when 'dinamica' then fabric.Image.fromURL(url_+'dinamica.png', (oImg)-> c.add oImg)
          when 'pushback' then fabric.Image.fromURL(url_+'pushback.png', (oImg)-> c.add oImg)
          when 'suelo' then fabric.Image.fromURL(url_+'suelo.png', (oImg)-> c.add oImg)
          #// scale image down, and flip it, before adding it onto canvas
          #oImg.scale(0.5).setFlipX(true);
      else
        c.add nobj

loadProperties = (c) ->
  obj = c.getActiveObject()
  if !obj
    unloadProperties(c)
    return
  $('#tools #properties').append("<label for='fill'>Fill</label><input id='fill' type='text' class='colorPicker' value='#{obj.fill}' />")
  $('#fill').colorpicker().on 'changeColor', (e) ->
    obj.setFill($(e.currentTarget).val())
    c.renderAll()
  $('#tools #properties').append("<label for='stroke'>Stroke</label><input id='stroke' type='text' class='colorPicker' value='#{obj.stroke}' />")
  $('#stroke').colorpicker().on 'changeColor', (e) ->
    obj.setStroke($(e.currentTarget).val())
    c.renderAll()
  $('#tools #properties').append("<label for='strokewidth'>Stroke Width</label><input id='strokewidth' type='number' value='#{obj.strokeWidth}' />")
  $('#strokewidth').on 'change', (e) ->
    obj.setStrokeWidth(parseInt($(e.currentTarget).val()))
    c.renderAll()

unloadProperties = (c) ->
  saveState(c)
  $('#tools #properties').html("")
jQuery ->
  canvas = new fabric.Canvas('c')
  canvas.setOverlayImage '../img/3rd_Floor_New.png', canvas.renderAll.bind(canvas)
  initTools(canvas)

  canvas.setWidth($(window).width())
  canvas.setHeight($(window).height() - $('#tools').outerHeight())

  loadState(canvas)

  $("#clear").click (d) ->
    canvas.clear()
    saveState(canvas)
  $('#clearall').click (d) ->
    clearState(canvas)
  $('#save').click (d) ->
    download = (url,name) ->
        $('<a>').attr({href:url,download:name})[0].click()
    download(canvas.toDataURL(),'floorplan.png')
  $('#undo').click (d) ->
    undoState(canvas)
  $('#redo').click (d) ->
    redoState(canvas)
  $('#zoom_mas').click (d) ->
    zoomMas(canvas)
  $('#zoom_menos').click (d) ->
    zoomMenos(canvas)


  canvas.on 'object:added', (d) ->
    saveState(canvas)
  canvas.on 'object:modified', (d) ->
    saveState(canvas)
  canvas.on 'object:selected', (d) ->
    loadProperties(canvas)
  canvas.on 'before:selection:cleared', (d) ->
    unloadProperties(canvas)
  canvas.on 'selection:cleared', (d) ->
    unloadProperties(canvas)


  $(document).keydown (e) ->
    if e.which == 90 && e.ctrlKey && e.shiftKey
       redoState(canvas)
    else if e.which == 90 && e.ctrlKey
       undoState(canvas)
    else if e.which == 46
      removeItem(canvas)
    else if e.which == 33
      zupItem(canvas)
    else if e.which == 34
      zdownItem(canvas)


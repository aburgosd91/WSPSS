/**************************Barcode-Type********************************/
var decoder_readers="code_128";
//var decoder_readers="code_39";
//var decoder_readers="code_39_vin";
//var decoder_readers="ean";
//var decoder_readers="ean_8";
//var decoder_readers="upc";
//var decoder_readers="upc_e";
//var decoder_readers="codabar";
/**************************Resolution (long side)********************************/
//var input_stream_size="320";
var input_stream_size="640";
//var input_stream_size="800";
//var input_stream_size="1280";
//var input_stream_size="1600";
//var input_stream_size="1920";
/**************************locator_patch-size********************************/
//var locator_patch_size="x-small";
//var locator_patch_size="small";
//var locator_patch_size="medium";
var locator_patch_size="large";
//var locator_patch_size="x-large";
/**************************Half-Sample********************************/
var locator_half_sample=false;
/*********************Single Channel************************/
var input_stream_single_channel=false;
/*********************numOfWorkers************************/
//var numOfWorkers="0";
var numOfWorkers="1";

function capturarJS(){
    alert("capturarJS");
}
$(function() {
    var App = {
        init: function() {
            App.attachListeners();
        },
        attachListeners: function() {
            var self = this;
            alert('attachListeners');
            $(".controls input[type=file]").on("change", function(e) {
                if (e.target.files && e.target.files.length) {
                    console.log(JSON.stringify(document.querySelector(".controls input[type=file]")));
                    App.decode(URL.createObjectURL(e.target.files[0]));
                    alert("File: "+e.target.files[0].name);
                }
            });
            $(".controls button").on("click", function(e) {
                alert('controls button');
                var input = document.querySelector(".controls input[type=file]");
                if (input.files && input.files.length) {
                    App.decode(URL.createObjectURL(input.files[0]));
                }
            });
            $(".controls .reader-config-group").on("change", "input, select", function(e) {
                alert('controls .reader-config-group');
                e.preventDefault();
                var $target = $(e.target),
                    value = $target.attr("type") === "checkbox" ? $target.prop("checked") : $target.val(),
                    name = $target.attr("name"),
                    state = self._convertNameToState(name);

                alert("Value of "+ state + " changed to " + value);    
                console.log("Value of "+ state + " changed to " + value);
                self.setState(state, value);
            });
        },
        _accessByPath: function(obj, path, val) {
            alert('_accessByPath');
            var parts = path.split('.'),
                depth = parts.length,
                setter = (typeof val !== "undefined") ? true : false;

            return parts.reduce(function(o, key, i) {
                if (setter && (i + 1) === depth) {
                    o[key] = val;
                }
                return key in o ? o[key] : {};
            }, obj);
        },
        _convertNameToState: function(name) {
            alert('_convertNameToState');
            return name.replace("_", ".").split("-").reduce(function(result, value) {
                return result + value.charAt(0).toUpperCase() + value.substring(1);
            });
        },
        detachListeners: function() {
            alert('detachListeners');
            $(".controls input[type=file]").off("change");
            $(".controls .reader-config-group").off("change", "input, select");
            $(".controls button").off("click");
        },
        decode: function(src) {
            alert('decode');
            var self = this,
                config = $.extend({}, self.state, {src: src});
            console.log(JSON.stringify(config));
            Quagga.decodeSingle(config, function(result) {});
        },
        setState: function(path, value) {
            alert('setState');
            var self = this;
            if (typeof self._accessByPath(self.inputMapper, path) === "function") {
                value = self._accessByPath(self.inputMapper, path)(value);
            }

            self._accessByPath(self.state, path, value);

            console.log(JSON.stringify(self.state));
            App.detachListeners();
            App.init();
        },
        inputMapper: {
            inputStream: {
                size: function(value){
                    return parseInt(value);
                }
            },
            numOfWorkers: function(value) {
                return parseInt(value);
            },
            decoder: {
                readers: function(value) {
                    return [value + "_reader"];
                }
            }
        },
        state: {
            inputStream: {
                size: 640,
                singleChannel: false
            },
            locator: {
                patchSize: "large",
                halfSample: false
            },
            numOfWorkers: 1,
            decoder: {
                readers: ["code_128_reader"]
            },
            locate: true,
            src: null
        }
    };
    
    App.init();

    function calculateRectFromArea(canvas, area) { // ENCUADRAR -> ENFOCAR CODIGO
        var canvasWidth = canvas.width,
            canvasHeight = canvas.height,
            top = parseInt(area.top)/100,
            right = parseInt(area.right)/100,
            bottom = parseInt(area.bottom)/100,
            left = parseInt(area.left)/100;

        top *= canvasHeight;
        right = canvasWidth - canvasWidth*right;
        bottom = canvasHeight - canvasHeight*bottom;
        left *= canvasWidth;

        return {
            x: left,
            y: top,
            width: right - left,
            height: bottom - top
        };
    }

    Quagga.onProcessed(function(result) { //PROCESO ENCONTRAR CODIGO
//        alert('Quagga.onProcessed');
        console.log(JSON.stringify(result));
        var drawingCtx = Quagga.canvas.ctx.overlay,
            drawingCanvas = Quagga.canvas.dom.overlay,
            area;
        if (result) {
            if (result.boxes) {
                drawingCtx.clearRect(0, 0, parseInt(drawingCanvas.getAttribute("width")), parseInt(drawingCanvas.getAttribute("height")));
                result.boxes.filter(function (box) {
                    return box !== result.box;
                }).forEach(function (box) {
                    Quagga.ImageDebug.drawPath(box, {x: 0, y: 1}, drawingCtx, {color: "green", lineWidth: 2});
                });
            }

            if (result.box) {
                Quagga.ImageDebug.drawPath(result.box, {x: 0, y: 1}, drawingCtx, {color: "#00F", lineWidth: 2});
            }

            if (result.codeResult && result.codeResult.code) {
                Quagga.ImageDebug.drawPath(result.line, {x: 'x', y: 'y'}, drawingCtx, {color: 'red', lineWidth: 3});
            }

            if (App.state.inputStream.area) {
                area = calculateRectFromArea(drawingCanvas, App.state.inputStream.area);
                drawingCtx.strokeStyle = "#0F0";
                drawingCtx.strokeRect(area.x, area.y, area.width, area.height);
            }
    }
    });

    Quagga.onDetected(function(result) {
//        alert("Quagga.onDetected");
        var code = result.codeResult.code,$node,
            canvas = Quagga.canvas.dom.image;
            alert(code);
        $node = $('<li><div class="thumbnail"><div class="imgWrapper"><img /></div><div class="caption"><h4 class="code"></h4></div></div></li>');
        $node.find("img").attr("src", canvas.toDataURL());
        $node.find("h4.code").html(code);
        $("#result_strip ul.thumbnails").prepend($node);
    });
}); 



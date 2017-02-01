var device = navigator.userAgent

if (device.match(/Iphone/i) || device.match(/Ipod/i) || device.match(/Android/i) || device.match(/J2ME/i) || device.match(/BlackBerry/i) || device.match(/iPhone|iPad|iPod/i) || device.match(/Opera Mini/i) || device.match(/IEMobile/i) || device.match(/Mobile/i) || device.match(/HTC/i))
{
//http://localhost:8080/NisiraWebOrdenes/
}
else
{
  // comentado 13_12_2013 abrir movil  window.location = "http://localhost:8080/NisiraWebOrdenes/faces/sistema/CerrarSesion.xhtml";
//    window.location = "http://soporte.nisira.com.pe:8069/NisiraWebOrdenes/faces/sistema/CerrarSesion.xhtml";
//    window.location = "http://172.168.1.174:8080/NisiraWebOrdenes/faces/sistema/CerrarSesion.xhtml";

}

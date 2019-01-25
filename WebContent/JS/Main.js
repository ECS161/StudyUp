
initMap()

function initMap() {
	window.view = new ol.View({
		center: ol.proj.fromLonLat([-121.751392674913, 38.52247515]), // Use Davis, CA as default coordinates
		zoom: 13
	})
	map = new ol.Map({
		target: 'map',
		layers: [
			new ol.layer.Tile({
				source: new ol.source.OSM()
			})
		],
		view: window.view
	});
	map.on("moveend", onMoveEnd);
}


function gotoLoc(lat, lon, bounds) {
	const coordinates = ol.proj.fromLonLat([lon, lat]);
	window.view.animate({center: coordinates, zoom: 13});
	if (bounds) {
		window.view.fit(ol.proj.transformExtent(bounds, 'EPSG:4326', 'EPSG:3857'), window.map.getSize())
	}
}

// These two functions based on https://openlayers.org/en/latest/examples/moveend.html
function wrapLon(value) {
	var worlds = Math.floor((value + 180) / 360);
	return value - (worlds * 360);
}

function onMoveEnd(e) {
	var map = e.map;
    var extent = map.getView().calculateExtent(map.getSize());
    var bottomLeft = ol.proj.toLonLat(ol.extent.getBottomLeft(extent));
    var topRight = ol.proj.toLonLat(ol.extent.getTopRight(extent));
    minLon = bottomLeft[1];
    minLat = wrapLon(bottomLeft[0]);
    maxLon = topRight[1];
    maxLat = wrapLon(topRight[0]);
    bounds = [minLon, minLat, maxLon, maxLat];
    bounds = minLon + "," + minLat + "," + maxLon + "," + maxLat;
    $.ajax({
		url: 'MoveServlet',
		data: {
			bounds: bounds
		},
		success: function(responseText) {
			console.log(responseText);
		}
	});
    console.log(bounds);
}

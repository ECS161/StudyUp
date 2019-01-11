
initMap()

function initMap() {
	window.view = new ol.View({
		center: ol.proj.fromLonLat([-121.751392674913, 38.52247515]),
		zoom: 13
	})
	window.map = new ol.Map({
		target: 'map',
		layers: [
			new ol.layer.Tile({
				source: new ol.source.OSM()
			})
		],
		view: window.view
	});
}

function gotoLoc(lat, lon) {
	const coords = ol.proj.fromLonLat([lon, lat]);
	window.view.animate({center: coords, zoom: 13});
//	window.view.fit(ol.proj.transformExtent([minLon, minLat, maxLon, maxLat], 'EPSG:4326', 'EPSG:3857'))
}

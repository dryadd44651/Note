let lastFilter = '';
//let src = null;
let dstC1 = null;
let dstC3 = null;
let dstC4 = null;
let width = 0;
let height = 0;

var controls;

controls = {
    filter: 'passThrough',
    setFilter: function(filter) {
      this.filter = filter;
      //filterName.innerHTML = filters[filter];
    },
    passThrough: function() { this.setFilter('passThrough'); },
    gray: function() { this.setFilter('gray'); },
    hsv: function() { this.setFilter('hsv'); },
    inRange: function() { this.setFilter('inRange'); },
    inRangeLow: 75,
    inRangeHigh: 150,
    threshold: function() { this.setFilter('threshold'); },
    thresholdValue: 100,
    adaptiveThreshold: function() { this.setFilter('adaptiveThreshold'); },
    adaptiveBlockSize: 3,
    gaussianBlur: function() { this.setFilter('gaussianBlur'); },
    gaussianBlurSize: 7,
    medianBlur: function() { this.setFilter('medianBlur'); },
    medianBlurSize: 5,
    bilateralFilter: function() { this.setFilter('bilateralFilter'); },
    bilateralFilterDiameter: 5,
    bilateralFilterSigma: 75,
    sobel: function() { this.setFilter('sobel'); },
    sobelSize: 3,
    scharr: function() { this.setFilter('scharr'); },
    laplacian: function() { this.setFilter('laplacian'); },
    laplacianSize: 3,
    canny: function() { this.setFilter('canny'); },
    cannyThreshold1: 150,
    cannyThreshold2: 300,
    cannyApertureSize: 3,
    cannyL2Gradient: false,
    contours: function() { this.setFilter('contours'); },
    contoursMode: 1,//cv.RETR_CCOMP,
    contoursMethod: 1,
    calcHist: function() { this.setFilter('calcHist'); },
    equalizeHist: function() { this.setFilter('equalizeHist'); },
    backprojection: function() { this.setFilter('backprojection'); },
    backprojectionRangeLow: 0,
    backprojectionRangeHigh: 150,
    morphology: function () { this.setFilter('morphology'); },
    morphologyShape: 1,
    morphologyOp: 1,
    morphologySize: 5,
    morphologyBorderType: 1,
  };

function startProcessing(input) {
	height = input.rows;
	width = input.cols;
	//src = new cv.Mat(input.rows, input.cols, cv.CV_8UC4);
	dstC1 = new cv.Mat(input.rows, input.cols, cv.CV_8UC1);
	dstC3 = new cv.Mat(input.rows, input.cols, cv.CV_8UC3);
	dstC4 = new cv.Mat(input.rows, input.cols, cv.CV_8UC4);
}
function stopProcessing() {
  
	//if (src != null && !src.isDeleted()) src.delete();
	if (dstC1 != null && !dstC1.isDeleted()) dstC1.delete();
	if (dstC3 != null && !dstC3.isDeleted()) dstC3.delete();
	if (dstC4 != null && !dstC4.isDeleted()) dstC4.delete();
  }

function passThrough(src) {
	return src;
  }
  
  function gray(src) {
	cv.cvtColor(src, dstC1, cv.COLOR_RGBA2GRAY);
	return dstC1;
  }
  
  function hsv(src) {
	cv.cvtColor(src, dstC3, cv.COLOR_RGBA2RGB);
	cv.cvtColor(dstC3, dstC3, cv.COLOR_RGB2HSV);
	return dstC3;
  }
  
  function canny(src) {
	cv.cvtColor(src, dstC1, cv.COLOR_RGBA2GRAY);
	cv.Canny(dstC1, dstC1, controls.cannyThreshold1, controls.cannyThreshold2, controls.cannyApertureSize, controls.cannyL2Gradient);
	return dstC1;
  }
  
  function inRange(src) {
	let lowValue = controls.inRangeLow;
	let lowScalar = new cv.Scalar(lowValue, lowValue, lowValue, 255);
  
	let highValue = controls.inRangeHigh;
	let highScalar = new cv.Scalar(highValue, highValue, highValue, 255);
	let low = new cv.Mat(height, width, src.type(), lowScalar);
	let high = new cv.Mat(height, width, src.type(), highScalar);
	cv.inRange(src, low, high, dstC1);
	low.delete(); high.delete();
	return dstC1;
  }
  
  function threshold(src) {
	cv.threshold(src, dstC4, controls.thresholdValue, 200, cv.THRESH_BINARY);
	return dstC4;
  }
  
  function adaptiveThreshold(src) {
	let mat = new cv.Mat(height, width, cv.CV_8U);
	cv.cvtColor(src, mat, cv.COLOR_RGBA2GRAY);
	cv.adaptiveThreshold(mat, dstC1, 200, cv.ADAPTIVE_THRESH_GAUSSIAN_C, cv.THRESH_BINARY, Number(controls.adaptiveBlockSize), 2);
	mat.delete();
	return dstC1;
  }
  
  function gaussianBlur(src) {
	cv.GaussianBlur(src, dstC4, {width: controls.gaussianBlurSize, height: controls.gaussianBlurSize}, 0, 0, cv.BORDER_DEFAULT);
	return dstC4;
  }
  
  function bilateralFilter(src) {
	let mat = new cv.Mat(height, width, cv.CV_8UC3);
	cv.cvtColor(src, mat, cv.COLOR_RGBA2RGB);
	cv.bilateralFilter(mat, dstC3, controls.bilateralFilterDiameter, controls.bilateralFilterSigma, controls.bilateralFilterSigma, cv.BORDER_DEFAULT);
	mat.delete();
	return dstC3;
  }
  
  function medianBlur(src) {
	cv.medianBlur(src, dstC4, controls.medianBlurSize);
	return dstC4;
  }
  
  function sobel(src) {
	var mat = new cv.Mat(height, width, cv.CV_8UC1);
	cv.cvtColor(src, mat, cv.COLOR_RGB2GRAY, 0);
	cv.Sobel(mat, dstC1, cv.CV_8U, 1, 0, controls.sobelSize, 1, 0, cv.BORDER_DEFAULT);
	mat.delete();
	return dstC1;
  }
  
  function scharr(src) {
	var mat = new cv.Mat(height, width, cv.CV_8UC1);
	cv.cvtColor(src, mat, cv.COLOR_RGB2GRAY, 0);
	cv.Scharr(mat, dstC1, cv.CV_8U, 1, 0, 1, 0, cv.BORDER_DEFAULT);
	mat.delete();
	return dstC1;
  }
  
  function laplacian(src) {
	var mat = new cv.Mat(height, width, cv.CV_8UC1);
	cv.cvtColor(src, mat, cv.COLOR_RGB2GRAY);
	cv.Laplacian(mat, dstC1, cv.CV_8U, controls.laplacianSize, 1, 0, cv.BORDER_DEFAULT);
	mat.delete();
	return dstC1;
  }
  
  let contoursColor = [];
  for (let i = 0; i < 10000; i++) {
	contoursColor.push([Math.round(Math.random() * 255), Math.round(Math.random() * 255), Math.round(Math.random() * 255), 0]);
  }
  
  function contours(src) {
	cv.cvtColor(src, dstC1, cv.COLOR_RGBA2GRAY);
	cv.threshold(dstC1, dstC4, 120, 200, cv.THRESH_BINARY);
	let contours  = new cv.MatVector();
	let hierarchy = new cv.Mat();
	cv.findContours(dstC4, contours, hierarchy, Number(controls.contoursMode), Number(controls.contoursMethod), {x: 0, y: 0});
	dstC3.delete();
	dstC3 = cv.Mat.ones(height, width, cv.CV_8UC3);
	for (let i = 0; i<contours.size(); ++i)
	{
	  let color = contoursColor[i];
	  cv.drawContours(dstC3, contours, i, color, 1, cv.LINE_8, hierarchy);
	}
	contours.delete(); hierarchy.delete();
	return dstC3;
  }
  
  function calcHist(src) {
	cv.cvtColor(src, dstC1, cv.COLOR_RGBA2GRAY);
	let srcVec = new cv.MatVector();
	srcVec.push_back(dstC1);
	let scale = 2;
	let channels = [0], histSize = [src.cols/scale], ranges = [0,255];
	let hist = new cv.Mat(), mask = new cv.Mat(), color = new cv.Scalar(0xfb, 0xca, 0x04, 0xff);
	cv.calcHist(srcVec, channels, mask, hist, histSize, ranges);
	let result = cv.minMaxLoc(hist, mask);
	var max = result.maxVal;
	cv.cvtColor(dstC1, dstC4, cv.COLOR_GRAY2RGBA);
	// draw histogram on src
	for(var i = 0; i < histSize[0]; i++)
	{
		var binVal = hist.data32F[i] * src.rows / max;
		cv.rectangle(dstC4, {x: i * scale, y: src.rows - 1}, {x: (i + 1) * scale - 1, y: src.rows - binVal/3}, color, cv.FILLED);
	}
	srcVec.delete();
	mask.delete();
	hist.delete();
	return dstC4;
  }
  
  function equalizeHist(src) {
	cv.cvtColor(src, dstC1, cv.COLOR_RGBA2GRAY, 0);
	cv.equalizeHist(dstC1, dstC1);
	return dstC1;
  }
  
  let base;
  
  function backprojection(src) {//project the probability of hist
	if (lastFilter !== 'backprojection') {
	  if (base instanceof cv.Mat)
		base.delete();
	  base = src.clone();
	  cv.cvtColor(base, base, cv.COLOR_RGB2HSV, 0);
	}
	cv.cvtColor(src, dstC3, cv.COLOR_RGB2HSV, 0);
	let baseVec = new cv.MatVector(), targetVec = new cv.MatVector();
	baseVec.push_back(base); targetVec.push_back(dstC3);
	let mask = new cv.Mat(), hist = new cv.Mat();
	let channels = [0], histSize = [50];
	let ranges;
	if (controls.backprojectionRangeLow < controls.backprojectionRangeHigh)
	  ranges = [controls.backprojectionRangeLow, controls.backprojectionRangeHigh];
	else
	  return src;
	cv.calcHist(baseVec, channels, mask, hist, histSize, ranges);
	cv.normalize(hist, hist, 0, 255, cv.NORM_MINMAX);
	cv.calcBackProject(targetVec, channels, hist, dstC1, ranges, 1);
	baseVec.delete();
	targetVec.delete();
	mask.delete();
	hist.delete();
	return dstC1;
  }
  
  function erosion(src) {
	let kernelSize = controls.erosionSize;
	let kernel = cv.Mat.ones(kernelSize, kernelSize, cv.CV_8U);
	let color = new cv.Scalar();
	cv.erode(src, dstC4, kernel, {x: -1, y: -1}, 1, Number(controls.erosionBorderType), color);
	kernel.delete();
	return dstC4;
  }
  
  function dilation(src) {
	let kernelSize = controls.dilationSize;
	let kernel = cv.Mat.ones(kernelSize, kernelSize, cv.CV_8U);
	let color = new cv.Scalar();
	cv.dilate(src, dstC4, kernel, {x: -1, y: -1}, 1, Number(controls.dilationBorderType), color);
	kernel.delete();
	return dstC4;
  }
  
  function morphology(src) {
	let kernelSize = controls.morphologySize;
	let kernel = cv.getStructuringElement(Number(controls.morphologyShape), {width: kernelSize, height: kernelSize});
	let color = new cv.Scalar();
	let op = Number(controls.morphologyOp);
	let image = src;
	if (op === cv.MORPH_GRADIENT || op === cv.MORPH_TOPHAT || op === cv.MORPH_BLACKHAT) {
	  cv.cvtColor(src, dstC3, cv.COLOR_RGBA2RGB);
	  image = dstC3;
	}
	cv.morphologyEx(image, dstC4, op, kernel, {x: -1, y: -1}, 1, Number(controls.morphologyBorderType), color);
	kernel.delete();
	return dstC4;
  }
  
	
	function resize(src,dst,barObj){//barObj is a html input object containing value and max
	//let trackbar = document.getElementById('trackbar');
		let w = (barObj.value/barObj.max)*src.cols;
		let h = (barObj.value/barObj.max)*src.rows;
		let dsize = new cv.Size(w, h);
		cv.resize(src, dst, dsize, 0, 0, cv.INTER_AREA);
		return dst
	}
	

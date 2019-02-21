new Morris.Area({

    element: 'areaChartContainer',
  
    data: [
    { y: '2011', a: 10, b: 15 },
    { y: '2012', a: 30,  b: 35 },
    { y: '2013', a: 10,  b: 25 },
    { y: '2014', a: 55,  b: 45 },
    { y: '2015', a: 30,  b: 20 },
    { y: '2016', a: 40,  b: 35 },
    { y: '2017', a: 10, b: 25 },
    { y: '2018', a: 25, b: 30 }
    ],
    lineWidth: 0,
    xLabelMargin: 10,
    yLabelMargin: 10,
    axes: false,
    pointSize: 0,
    hideHover:true,
    grid: false,
    xkey: 'y',
    ykeys: ['a', 'b'],
    labels: ['Series A', 'Series B']
  });
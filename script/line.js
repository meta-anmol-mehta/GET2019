new Morris.Line({

    element: 'lineChartContainer',
  
    data: [
    { y: '2009', a: 0, b: 0 , c:0 },
    { y: '2010', a: 150, b: 30 , c:50 },
    { y: '2011', a: 20, b: 50 , c:150 },
    { y: '2012', a: 150,  b: 80 , c:40 },
    { y: '2013', a: 20,  b: 110 , c:150 },
    { y: '2014', a: 50,  b: 150 , c:40 },
    { y: '2015', a: 150,  b: 170 , c:130 }
    ],
    lineColors: [
    '#007bff','#e785da','#00bcd2'
    ],
    hideHover:true, 
    xkey: 'y',
    ykeys: ['a', 'b' ,'c'],
    labels: ['Series A', 'Series B' , 'Series C']
  });
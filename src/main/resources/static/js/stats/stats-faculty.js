// document.addEventListener("DOMContentLoaded", function () {
//     var chartDom = document.getElementById('main-frame');
//     var myChart = echarts.init(chartDom);
//     var option;
//     let xAxisData = [];
//     let series = [];
//     let seriesData = []
//     $.ajax({
//         url: '/school/stats_result',
//         type: 'GET',
//         dataType: 'json',
//         success: function (data) {
//             // Успешно получили данные
//             processDataForChart(data);
//             // После обработки данных вызываем setOption()
//             option && myChart.setOption(option);
//         },
//         error: function (xhr, status, error) {
//             console.error('Ошибка при получении данных:', error);
//         }
//     });
//
//     function processDataForChart(data) {
//
//         Object.keys(data).forEach(testName => {
//             const facultyData = data[testName];
//
//             Object.keys(facultyData).forEach(facultyName => {
//                 xAxisData.push(facultyName);
//                 seriesData.push(facultyData[facultyName]);
//             });
//
//             console.log(xAxisData)
//
//             console.log(seriesData)
//
//             series.push({
//                 name: testName,
//                 type: 'line',
//                 data: seriesData,
//                 markPoint: {
//                     data: [
//                         {type: 'max', name: 'Max'},
//                         {type: 'min', name: 'Min'}
//                     ]
//                 },
//                 markLine: {
//                     data: [{type: 'average', name: 'Avg'}]
//                 }
//             });
//         });
//
//         // После обработки данных формируем объект option
//         option = {
//             title: {
//                 text: 'Результаты теста по факультетам'
//             },
//             tooltip: {
//                 trigger: 'axis'
//             },
//             legend: {},
//             toolbox: {
//                 show: true,
//                 feature: {
//                     dataZoom: {
//                         yAxisIndex: 'none'
//                     },
//                     dataView: {readOnly: false},
//                     magicType: {type: ['line', 'bar']},
//                     restore: {},
//                     saveAsImage: {}
//                 }
//             },
//             xAxis: {
//                 type: 'category',
//                 boundaryGap: false,
//                 data: xAxisData
//             },
//             yAxis: {
//                 type: 'value',
//                 axisLabel: {
//                     formatter: '{value}'
//                 }
//             },
//             series: series
//         };
//     }
// });

document.addEventListener("DOMContentLoaded", function () {
    $.ajax({
        url: '/school/stats_result',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            // Успешно получили данные
            processDataForCharts(data);
        },
        error: function (xhr, status, error) {
            console.error('Ошибка при получении данных:', error);
        }
    });

    function processDataForCharts(data) {
        Object.keys(data).forEach(testName => {
            const chartDom = document.createElement('div'); // Создаем div для каждого графика
            chartDom.setAttribute('id', testName + '-chart'); // Устанавливаем уникальный id для каждого графика
            chartDom.setAttribute('style', 'height: 500px;'); // Задаем высоту графика
            document.getElementById('main-frame').appendChild(chartDom); // Добавляем график в основной контейнер

            const myChart = echarts.init(chartDom);
            const xAxisData = [];
            const seriesData = [];
            const series = [];

            const facultyData = data[testName];
            Object.keys(facultyData).forEach(facultyName => {
                xAxisData.push(facultyName);
                seriesData.push(facultyData[facultyName]);
            });

            series.push({
                name: testName,
                type: 'line',
                data: seriesData,
                markPoint: {
                    data: [
                        {type: 'max', name: 'Max'},
                        {type: 'min', name: 'Min'}
                    ]
                },
                markLine: {
                    data: [{type: 'average', name: 'Avg'}]
                },
                itemStyle: {
                    color: '#6c96a6' // Цвет линии
                },
                lineStyle: {
                    color: '#6c96a6' // Цвет маркеров
                }
            });

            const option = {
                title: {
                    text: 'Результаты теста \n' + testName + ' по факультетам',
                    textStyle: {
                        color: '#333' // Цвет заголовка
                    }
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    textStyle: {
                        color: '#333' // Цвет текста легенды
                    }
                },
                toolbox: {
                    show: true,
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        dataView: {readOnly: false},
                        magicType: {type: ['line', 'bar']},
                        restore: {},
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: xAxisData,
                    axisLine: {
                        lineStyle: {
                            color: '#999' // Цвет линии оси X
                        }
                    },
                    axisLabel: {
                        color: '#666' // Цвет подписей оси X
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLabel: {
                        formatter: '{value}',
                        color: '#666' // Цвет подписей оси Y
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#999' // Цвет линии оси Y
                        }
                    }
                },
                series: series
            };

            myChart.setOption(option);
        });
    }
});


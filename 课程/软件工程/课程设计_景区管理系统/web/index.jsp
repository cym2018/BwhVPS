<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>骊珠风景区</title>
    <jsp:include page="head1.txt"/>
    <meta charset="utf-8">
    <meta name="format-detection" content="telephone=no"/>
    <link rel="shortcut icon" href="images/favicon.ico"/>
    <link rel="stylesheet" href="booking/css/booking.css">
    <link rel="stylesheet" href="css/camera.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <script src="js/owl.carousel.js"></script>
    <script src="js/camera.js"></script>
    <!--[if (gt IE 9)|!(IE)]><!-->
    <script src="js/jquery.mobile.customized.min.js"></script>
    <!--<![endif]-->
    <script src="booking/js/booking.js"></script>
    <script>
        $(document).ready(function () {
            jQuery('#camera_wrap').camera({
                loader: false,
                pagination: false,
                minHeight: '444',
                thumbnails: false,
                height: '48.375%',
                caption: true,
                navigation: true,
                fx: 'mosaic'
            });
            /*carousel*/
            var owl = $("#owl");
            owl.owlCarousel({
                items: 2, //10 items above 1000px browser width
                itemsDesktop: [995, 2], //5 items between 1000px and 901px
                itemsDesktopSmall: [767, 2], // betweem 900px and 601px
                itemsTablet: [700, 2], //2 items between 600 and 0
                itemsMobile: [479, 1], // itemsMobile disabled - inherit from itemsTablet option
                navigation: true,
                pagination: false
            });
            $().UItoTop({easingType: 'easeOutQuart'});
        });
    </script>
</head>
<body class="page1" id="top">
<jsp:include page="header1.txt"/>

<div class="slider_wrapper">
    <div id="camera_wrap" class="">
        <div data-src="images/3.jpg">
            <div class="caption fadeIn">
                <h2>十一黄金周</h2>
                <div class="price">
                    史无前例
                    <span>五折巨惠</span>
                </div>
                <a href="#">了解更多</a>
            </div>
        </div>
        <div data-src="images/4.jpg">
            <div class="caption fadeIn">
                <h2>十一黄金周</h2>
                <div class="price">
                    史无前例
                    <span>五折巨惠</span>
                </div>
                <a href="#">了解更多</a>
            </div>
        </div>
        <div data-src="images/书简湖.jpg">
            <div class="caption fadeIn">
                <h2>十一黄金周</h2>
                <div class="price">
                    史无前例
                    <span>五折巨惠</span>
                </div>
                <a href="#">了解更多</a>
            </div>
        </div>
    </div>
</div>
<!--==============================Content=================================-->
<div class="content">
    <div class="ic">More Website Templates @ TemplateMonster.com - February 10, 2019!</div>
    <div class="container_12">
        <div class="grid_4">
            <div class="banner">
                <img src="images/倒悬山.jpg" alt="">
                <div class="label">
                    <div class="title">落魄山</div>
                    <div class="price">FROM<span>￥ 120</span></div>
                    <a href="#">LEARN MORE</a>
                </div>
            </div>
        </div>
        <div class="grid_4">
            <div class="banner">
                <img src="images/1.jpg" alt="">
                <div class="label">
                    <div class="title">仙草山</div>
                    <div class="price">FROM<span>￥ 120</span></div>
                    <a href="#">LEARN MORE</a>
                </div>
            </div>
        </div>
        <div class="grid_4">
            <div class="banner">
                <img src="images/9.jpg" alt="">
                <div class="label">
                    <div class="title">神秀峰</div>
                    <div class="price">FROM<span>￥ 120</span></div>
                    <a href="#">LEARN MORE</a>
                </div>
            </div>
        </div>
        <div class="clear"></div>
        <div class="grid_6">
            <h3>Booking Form</h3>
            <form id="bookingForm">
                <div class="fl1">
                    <div class="tmInput">
                        <input name="Name" placeHolder="Name:" type="text"
                               data-constraints='@NotEmpty @Required @AlphaSpecial'>
                    </div>
                    <div class="tmInput">
                        <input name="Country" placeHolder="Country:" type="text" data-constraints="@NotEmpty @Required">
                    </div>
                </div>
                <div class="fl1">
                    <div class="tmInput">
                        <input name="Email" placeHolder="Email:" type="text"
                               data-constraints="@NotEmpty @Required @Email">
                    </div>
                    <div class="tmInput mr0">
                        <input name="Hotel" placeHolder="Hotel:" type="text" data-constraints="@NotEmpty @Required">
                    </div>
                </div>
                <div class="clear"></div>
                <strong>Check-in</strong>
                <label class="tmDatepicker">
                    <input type="text" name="Check-in" placeHolder='10/05/2018'
                           data-constraints="@NotEmpty @Required @Date">
                </label>
                <div class="clear"></div>
                <strong>Check-out</strong>
                <label class="tmDatepicker">
                    <input type="text" name="Check-out" placeHolder='20/05/2018'
                           data-constraints="@NotEmpty @Required @Date">
                </label>
                <div class="clear"></div>
                <div class="tmRadio">
                    <p>Comfort</p>
                    <input name="Comfort" type="radio" id="tmRadio0"
                           data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])' checked/>
                    <span>Cheap</span>
                    <input name="Comfort" type="radio" id="tmRadio1"
                           data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])'/>
                    <span>Standart</span>
                    <input name="Comfort" type="radio" id="tmRadio2"
                           data-constraints='@RadioGroupChecked(name="Comfort", groups=[RadioGroup])'/>
                    <span>Lux</span>
                </div>
                <div class="clear"></div>
                <div class="fl1 fl2">
                    <em>Adults</em>
                    <select name="Adults" class="tmSelect auto" data-class="tmSelect tmSelect2" data-constraints="">
                        <option>1</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                    <div class="clear"></div>
                    <em>Rooms</em>
                    <select name="Rooms" class="tmSelect auto" data-class="tmSelect tmSelect2" data-constraints="">
                        <option>1</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                    </select>
                </div>
                <div class="fl1 fl2">
                    <em>Children</em>
                    <select name="Children" class="tmSelect auto" data-class="tmSelect tmSelect2" data-constraints="">
                        <option>0</option>
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                    </select>
                </div>
                <div class="clear"></div>
                <div class="tmTextarea">
                    <textarea name="Message" placeHolder="Message"
                              data-constraints='@NotEmpty @Required @Length(min=20,max=999999)'></textarea>
                </div>
                <a href="#" class="btn" data-type="submit">Submit</a>
            </form>
        </div>
        <div class="grid_5 prefix_1">
            <h3>Welcome</h3>
            <img src="images/page1_img1.jpg" alt="" class="img_inner fleft">
            <div class="extra_wrapper">
                <p>Lorem ipsum dolor sit ere amet, consectetur ipiscin.</p>
                In mollis erat mattis neque facilisis, sit ametiol
            </div>
            <div class="clear cl1"></div>
            <p>Find the detailed description of this <span class="col1">freebie</span> at TemplateMonster blog.</p>
            <p><span class="col1">Travel Website Templates</span> category offers you a variety of designs that are
                perfect for travel sphere of business.</p>
            Proin pharetra luctus diam, a scelerisque eros convallis
            <h4>Clients�?Quotes</h4>
            <blockquote class="bq1">
                <img src="images/page1_img2.jpg" alt="" class="img_inner noresize fleft">
                <div class="extra_wrapper">
                    <p>Duis massa elit, auctor non pellentesque vel, aliquet sit amet erat. Nullam eget dignissim nisi,
                        aliquam feugiat nibh. </p>
                    <div class="alright">
                        <div class="col1">Miranda Brown</div>
                        <a href="#" class="btn">More</a>
                    </div>
                </div>
            </blockquote>
        </div>
        <div class="grid_12">
            <h3 class="head1">Latest News</h3>
        </div>
        <div class="grid_4">
            <div class="block1">
                <time datetime="2014-01-01">10<span>Jan</span></time>
                <div class="extra_wrapper">
                    <div class="text1 col1"><a href="#">Aliquam nibh</a></div>
                    Proin pharetra luctus diam, any scelerisque eros convallisumsan. Maecenas vehicula egestas
                </div>
            </div>
        </div>
        <div class="grid_4">
            <div class="block1">
                <time datetime="2014-01-01">21<span>Jan</span></time>
                <div class="extra_wrapper">
                    <div class="text1 col1"><a href="#">Etiam dui eros</a></div>
                    Any scelerisque eros vallisumsan. Maecenas vehicula egestas natis. Duis massa elit, auctor non
                </div>
            </div>
        </div>
        <div class="grid_4">
            <div class="block1">
                <time datetime="2014-01-01">15<span>Feb</span></time>
                <div class="extra_wrapper">
                    <div class="text1 col1"><a href="#">uamnibh Edeto</a></div>
                    Ros convallisumsan. Maecenas vehicula egestas venenatis. Duis massa elit, auctor non
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer1.txt"/>
</body>
</html>


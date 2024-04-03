$(document).ready(function(){
    var slideIndex = 0;
    showSlides();

    function showSlides() {
        var i;
        var slides = $(".slide");
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {slideIndex = 1}
        slides[slideIndex-1].style.display = "block";
        setTimeout(showSlides, 2000); // 2초마다 슬라이드 넘어감
    }

    $(".prev").click(function() {
        slideIndex--;
        showSlides();
    });

    $(".next").click(function() {
        slideIndex++;
        showSlides();
    });
});
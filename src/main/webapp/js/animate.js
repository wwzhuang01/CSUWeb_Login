function animate(obj, target, callback) {
    clearInterval(obj.timer);       // 先清除以前的定时器，只保留当前的一个定时器执行

    obj.timer = setInterval(function() {

        var step = (target - obj.offsetLeft) / 10;
        step = step > 0 ? Math.ceil(step) : Math.floor(step);    // 令步长为整数

        if (obj.offsetLeft == target) {
            clearInterval(obj.timer);
            callback && callback();
        }

        obj.style.left = obj.offsetLeft + step + 'px';

    }, 15);
}


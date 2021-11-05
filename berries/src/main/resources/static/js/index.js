let modal = document.getElementById('myModal');

let btn = document.getElementById('myBtn');

let span = document.getElementsByClassName('close')[0];

let btnEdit = document.getElementsByName("myBtnEdit");

let images = document.getElementsByClassName("productImage");

Array.from(images).forEach(
    img => {
        img.addEventListener('click', () => {
            img.style.height = '500px';
            img.style.width = '500px';
            decrease(img);
        })
    }
);

let increase = function(img){
    img.addEventListener('click', () => {
        img.style.height = '500px';
        img.style.width = '500px';
        decrease(img);
    });
};

let decrease = function(img){
    img.addEventListener('click', () => {
        img.style.height = '100px';
        img.style.width = '100px';
        increase(img);
    });

};

// window.onclick = function(){
//     Array.from(images).forEach(
//         img => {
//                 img.style.height = '100px';
//                 img.style.width = '100px';
//         }
//     )
// };

Array.from(btnEdit).forEach(
    el => {
        el.addEventListener('click', () => {
            let modalEdit = document.getElementById(el.value);
            modalEdit.style.display = 'block';
            modalEdit.getElementsByClassName('closeEdit')[0].addEventListener('click',
                    () => {
                        modalEdit.style.display = 'none';
                    }
                )
        })
    }
);

btn.onclick = function() {
    modal.style.display = 'block';
};

span.onclick = function() {
    modal.style.display = 'none';
};
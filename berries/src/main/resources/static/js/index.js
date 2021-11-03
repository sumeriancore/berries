let modal = document.getElementById('myModal');

let btn = document.getElementById('myBtn');

let span = document.getElementsByClassName('close')[0];

let btnEdit = document.getElementsByName("myBtnEdit");

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
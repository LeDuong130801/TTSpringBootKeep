
function genModal(idModal, idOpen, idClose) {
    var modal = document.getElementById(idModal);
            $("#" + idOpen).click(function () {
                modal.style.display = "block";
            });
            $("#" + idClose).click(function () {
                modal.style.display = "none";
            });
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}
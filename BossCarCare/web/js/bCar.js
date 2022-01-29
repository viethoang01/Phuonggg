function detailing() {
    document.getElementById('detailing-content').style.display = 'block';
    document.getElementById('process-content').style.display = 'none';
    document.getElementById('detailing').style.borderBottom = '2px solid #2C72C6';
    document.getElementById('detailing').style.color = '#2C72C6';
    document.getElementById('process').style.borderBottom = '1px solid gray';
    document.getElementById('process').style.color = 'gray';
}
function process() {
    document.getElementById('process-content').style.display = 'block';
    document.getElementById('detailing-content').style.display = 'none';
    document.getElementById('process').style.borderBottom = '2px solid #2C72C6';
    document.getElementById('process').style.color = '#2C72C6';
    document.getElementById('detailing').style.borderBottom = '1px solid gray';
    document.getElementById('detailing').style.color = 'gray';
}
function dichvu_enter() {
    document.getElementById('dichvu_content').style.width="100%";
 
}
function dichvu_leave() {
    document.getElementById('dichvu_content').style.width="0";

}
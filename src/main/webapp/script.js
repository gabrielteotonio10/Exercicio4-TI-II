function showMessage(text, tipo) {
    const msgDiv = document.createElement('div');
    msgDiv.className = `message ${tipo}`; 
    msgDiv.textContent = text;

    document.body.appendChild(msgDiv);

    setTimeout(() => {
        msgDiv.style.opacity = '0';
        setTimeout(() => msgDiv.remove(), 500);
    }, 3000);
}

document.addEventListener('DOMContentLoaded', function() {
    const urlParams = new URLSearchParams(window.location.search);
    const status = urlParams.get('status');

    if(status === 'sucesso') {
        showMessage('Evento cadastrado com sucesso!', 'success');
    } else if(status === 'removido') {
        showMessage('Evento removido com sucesso!', 'success');
    } else if(status === 'erro') {
        showMessage('Ocorreu um erro. Tente novamente.', 'error');
    }
});

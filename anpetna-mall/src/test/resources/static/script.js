    async function loadHTML(id, url) {
    try {
    const res = await fetch(url);
    if(!res.ok) throw new Error('Network response not ok');
    const text = await res.text();
    document.getElementById(id).innerHTML = text;
    return true;
} catch(e) {
    document.getElementById(id).innerHTML = `<p>로딩 실패: ${url}</p>`;
    return false;
}
}

    async function init() {
    const hLoaded = await loadHTML('header-placeholder', '../templates/layout/header.html');
    const sLoaded = await loadHTML('sidebar-placeholder', '../templates/layout/sideMenu.html');
    await loadHTML('footer-placeholder', '../templates/layout/footer.html');

    if(hLoaded && sLoaded) {
    bindEvents();
}
}

    function bindEvents() {
    // 사이드바 토글
    const sidebar = document.getElementById('sidebar');
    const mainContent = document.getElementById('main-content');
    const toggleBtn = document.getElementById('sidebarToggle');

    toggleBtn.addEventListener('click', () => {
    sidebar.classList.toggle('collapsed');
    mainContent.classList.toggle('collapsed');
});

    // 마이페이지 드롭다운
    const mypageBtn = document.getElementById('mypageBtn');
    const mypageMenu = document.getElementById('mypageMenu');

    mypageBtn.addEventListener('click', (e) => {
    e.stopPropagation(); // 클릭 이벤트 버블링 막기
    mypageMenu.classList.toggle('active');
});

    document.addEventListener('click', () => {
    mypageMenu.classList.remove('active');
});

    // 사이드바 메뉴 클릭 이벤트
    const adminMenu = document.getElementById('admin-menu');
    const userMenu = document.getElementById('user-menu');
    const content = document.getElementById('main-content');

    async function loadPageContent(page) {
    switch (page) {
    case 'product-management':
    try {
    const res = await fetch('item/itemList.html');
    if (!res.ok) throw new Error('페이지 로드 실패');
    const html = await res.text();
    content.innerHTML = html;
} catch (e) {
    content.innerHTML = `<p>상품 상세 페이지 로드 실패: ${e.message}</p>`;
}
    break;
    case 'sales-statistics':
    try {
    const res = await fetch('admin/salesStatistics.html');
    if (!res.ok) throw new Error('페이지 로드 실패');
    const html = await res.text();
    content.innerHTML = html;
} catch (e) {
    content.innerHTML = `<p>상품 상세 페이지 로드 실패: ${e.message}</p>`;
}
    break;
    case 'order-management':
    try {
    const res = await fetch('admin/orderManage.html');
    if (!res.ok) throw new Error('페이지 로드 실패');
    const html = await res.text();
    content.innerHTML = html;
} catch (e) {
    content.innerHTML = `<p>상품 상세 페이지 로드 실패: ${e.message}</p>`;
}
    break;
    case 'cart':
    try {
    const res = await fetch('cart/cart.html');
    if (!res.ok) throw new Error('페이지 로드 실패');
    const html = await res.text();
    content.innerHTML = html;
} catch (e) {
    content.innerHTML = `<p>상품 상세 페이지 로드 실패: ${e.message}</p>`;
}
    break;
    case 'wishlist':
    try {
    const res = await fetch('cart/wishList.html');
    if (!res.ok) throw new Error('페이지 로드 실패');
    const html = await res.text();
    content.innerHTML = html;
} catch (e) {
    content.innerHTML = `<p>상품 상세 페이지 로드 실패: ${e.message}</p>`;
}
    break;
    case 'product-list':
    content.innerHTML = `<h2>상품 리스트</h2><p>판매 중인 상품들을 확인하세요.</p>`;
    break;
    case 'product-detail':
    content.innerHTML = `<h2>상품 상세 페이지</h2><p>상품에 대한 상세 정보를 확인할 수 있습니다.</p>`;
    break;
    case 'order-history':
    try {
    const res = await fetch('order/orderList.html');
    if (!res.ok) throw new Error('페이지 로드 실패');
    const html = await res.text();
    content.innerHTML = html;
} catch (e) {
    content.innerHTML = `<p>상품 상세 페이지 로드 실패: ${e.message}</p>`;
}
    break;
    default:
    content.innerHTML = `<h1>환영합니다!</h1><p>애견용품 쇼핑몰에 오신 것을 환영합니다.</p>`;
}
}

    adminMenu.addEventListener('click', (e) => {
    if(e.target.tagName === 'LI'){
    loadPageContent(e.target.getAttribute('data-page'));
    if(window.innerWidth <= 768){
    // 모바일이면 메뉴 닫기
    sidebar.classList.add('collapsed');
    mainContent.classList.add('collapsed');
}
}
});
    userMenu.addEventListener('click', (e) => {
    if(e.target.tagName === 'LI'){
    loadPageContent(e.target.getAttribute('data-page'));
    if(window.innerWidth <= 768){
    sidebar.classList.add('collapsed');
    mainContent.classList.add('collapsed');
}
}
});
}

    init();


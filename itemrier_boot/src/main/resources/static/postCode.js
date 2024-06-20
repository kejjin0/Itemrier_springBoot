// postcode.js

function loadPostcodeSearch(setZonecode, setAdd, closeModal) {
    new daum.Postcode({
        oncomplete: function(data) {
            let fullAddress = data.address;
            let extraAddress = '';

            const { addressType, bname, buildingName } = data;
            if (addressType === 'R') {
                if (bname !== '') {
                    extraAddress += bname;
                }
                if (buildingName !== '') {
                    extraAddress += `${extraAddress !== '' ? ', ' : ''}${buildingName}`;
                }
                fullAddress += `${extraAddress !== '' ? ` ${extraAddress}` : ''}`;
            }
            // fullAddress -> 전체 주소반환
            setAdd(fullAddress);
            setZonecode(data.zonecode);
            closeModal();
        }
    }).open();
}

// 전역으로 설정
window.loadPostcodeSearch = loadPostcodeSearch;

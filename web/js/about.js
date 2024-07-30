// holds the data of all the team members
const teamMembers = [
    {
        name: "Rumesa Nadeem",
        id: "100869723",
        email: "rumesa.nadeem@ontariotechu.net"
    },
    {
        name: "Sanhith Amarathunge",
        id: "100868227",
        email: "sanhith.amarathunge@ontariotechu.net"
    },
    {
        name: "Rosie Khurmi",
        id: "100862409",
        email: "rosie.khurmi@ontariotechu.net"
    },
    {
        name: "Paul Joseph",
        id: "100879975",
        email: "paul.joseph3@ontariotechu.net"
    },
];

// populates HTML with team members
function createTeamMember(member) {

    // Create HTML Element
    let card = document.createElement('div');

    // Adds elements of each team member to the HTML Element
    card.className = "column";
    card.innerHTML = `

        <div class="card">
            <div class="container">
                <h2>${member.name}</h2>
                <p class="title">${member.id}</p>
                <a href="mailto:${member.email}" class="email">${member.email}</a></p>
            </div>    
        </div>`;

    // Allow copy of email address
    card.querySelector('.email').addEventListener('click', function(event) {
        event.preventDefault();
        const email = event.target.textContent;
        navigator.clipboard.writeText(email).then(() => {
        }).catch(err => {
            console.error('Failed to copy email: ', err);
        });
    });

    // Returns card
    return card;
}

// populates team members in about section
function addTeamMember() {
    // New card for each team member
    let teamMembersContainer = document.getElementById('teamMembers');
    teamMembers.forEach(member => {
        let memberCard = createTeamMember(member);
        teamMembersContainer.appendChild(memberCard);
    });
}

addTeamMember();